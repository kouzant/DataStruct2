package structure;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

class Node{
	private Node leftNode;
	private Node rightNode;
	private Flights data;
	private long MaxArr;
	
	public Node getLeftNode(){
		return leftNode;
	}
	public Node getRightNode(){
		return rightNode;
	}
	public Flights getData(){
		return data;
	}
	public long getMaxArr(){
		return MaxArr;
	}
	public void setLeftNode(Node leftNode){
		this.leftNode=leftNode;
	}
	public void setRightNode(Node rightNode){
		this.rightNode=rightNode;
	}
	public void setData(Flights data){
		this.data=data;
	}
	public void setMaxArr(long MaxArr){
		this.MaxArr=MaxArr;
	}
	
	Node(Flights data){
		this.leftNode=null;
		this.rightNode=null;
		this.data=data;
		this.MaxArr=0L;
	}
	Node(){
		this.leftNode=null;
		this.rightNode=null;
		this.data=null;
		this.MaxArr=0L;
	}
	Node(Node node){
		this.leftNode=node.getLeftNode();
		this.rightNode=node.getRightNode();
		this.data=node.getData();
		this.MaxArr=node.getMaxArr();
	}
	private Flights minValue(){
		if(leftNode==null)
			return data;
		else return leftNode.minValue();
	}
	public boolean remove(Flights data, Node parent){
		long compareR=data.getDepTime()-this.data.getDepTime();
		if(compareR>0){
			if(rightNode!=null)
				return rightNode.remove(data, this);
			else
				return false;
		}else if(compareR<0){
			if(leftNode!=null)
				return leftNode.remove(data, this);
			else
				return false;
		}else{
			if(leftNode!=null && rightNode!=null){
				this.data=rightNode.minValue();
				rightNode.remove(this.data, this);
			}else if(parent.leftNode==this){
				parent.leftNode=(leftNode!=null)?leftNode:rightNode;
			}else if(parent.rightNode==this){
				parent.rightNode=(leftNode!=null)?leftNode:rightNode;
			}
			return true;
		}
	}
}

public class BinarySearchTree<E>{
	Node root;
	int size=0;
	Node resultNode=null;
	//Simply Linked List used as stack
	SimplyLinkedList<Node> travPath=new SimplyLinkedList<Node>();
	SimplyLinkedList<Flights> periodS;
	
	//Adds a new value to the tree
	public void add(Flights data){
		if(root==null && data!=null){
			root=new Node(data);
			root.setMaxArr(data.getArrTime());
			System.out.println("Value "+data+" inserted at the root");
			size++;
		}else if(data!=null){
			root=add(root,data);
			
			long curArr=data.getArrTime();
			while(travPath.getLength()!=0){
				Node index=travPath.removeHead();
				long indexMax=index.getMaxArr();
				if(curArr>indexMax){
					index.setMaxArr(curArr);
				}else{
					break;
				}
			}
		}
	}
	
	//Adds a new value to the tree
	private Node add(Node index,Flights data){
		Node indexNode=new Node(index);
		travPath.addHead(indexNode);
		long compareR=indexNode.getData().getDepTime()-data.getDepTime();
		//compareR==0
		if(compareR==0)
			return indexNode;
		//compareR>0
		if(compareR>0){
			if(indexNode.getLeftNode()!=null){
				indexNode.setLeftNode(add(indexNode.getLeftNode(),data));
			}else{
				indexNode.setLeftNode(new Node(data));
				//Set MaxArr
				indexNode.getLeftNode().setMaxArr(data.getArrTime());
				System.out.println("Value "+data+" inserted at left child");
				size++;
			}
		}else if(compareR<0){
			if(indexNode.getRightNode()!=null){
				indexNode.setRightNode(add(indexNode.getRightNode(),data));
			}else{
				indexNode.setRightNode(new Node(data));
				//Set MaxArr
				indexNode.getRightNode().setMaxArr(data.getArrTime());
				System.out.println("Value "+data+" inserted at right child");
				size++;
			}
		}
		return indexNode;
	}
	
	//Get the value of a node
	public Flights get(long index){
		if(root==null)
			return null;
		Node indexNode=root;
		long compareR;
		while((compareR=indexNode.getData().getDepTime()-index)!=0){
			if(compareR>0){
				if(indexNode.getLeftNode()!=null){
					indexNode=indexNode.getLeftNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			}else if(compareR<0){
				if(indexNode.getRightNode()!=null){
					indexNode=indexNode.getRightNode();
					System.out.println("Traversed value is: "+indexNode.getData());
				}else{
					return null;
				}
			}
		}
		return indexNode.getData();
	}
	
	//Remove Node
	public boolean remove(Flights data){
		if(root==null){
			return false;
		}else{
			if(root.getData().getDepTime()==data.getDepTime()){
				Node dummyNode=new Node(new Flights("",new Date(0),new Date(0)));
				dummyNode.setLeftNode(root);
				boolean removeRes=root.remove(data, dummyNode);
				root=dummyNode.getLeftNode();
				return removeRes;
			}else{
				return root.remove(data, null);
			}
		}
	}
	//BST to List
	public SimplyLinkedList<Flights> toList(){
		SimplyLinkedList<Flights> theList=new SimplyLinkedList<Flights>();
		treeToList(root,theList);
		return theList;
	}
	//inOrder
	private void treeToList(Node indexNode, SimplyLinkedList<Flights> theList){
		if(indexNode!=null){
			System.out.println("IndexNode: "+indexNode.getData().getFlightCode());
			System.out.println("MaxArr: "+new Date(indexNode.getMaxArr()));
			treeToList(indexNode.getLeftNode(), theList);
			//System.out.println("Left Node");
			theList.addTail(indexNode.getData());
			treeToList(indexNode.getRightNode(), theList);
			//System.out.println("Right Node");
		}
	}
	public void searchNode(Node indexNode, String flightCode){
		if(indexNode!=null){
			if(indexNode.getData().getFlightCode().equals(flightCode))
				resultNode=indexNode;
			searchNode(indexNode.getLeftNode(), flightCode);
			searchNode(indexNode.getRightNode(), flightCode);
		}
	}
	public void delFlight(String flightCode){
		searchNode(root,flightCode);
		Flights delFlight=resultNode.getData();
		remove(delFlight);
	}
	public SimplyLinkedList<Flights> searchPeriod(Date startTime, Date finishTime){
		periodS=new SimplyLinkedList<Flights>();
		dummy(root, startTime, finishTime);
		
		return periodS;
	}
	
	public void dummy(Node indexNode, Date startTime, Date finishTime){
		if(indexNode!=null){
			float indexDep=indexNode.getData().getDepartureTime().getTime();
			if(indexDep>=startTime.getTime() && indexDep<=finishTime.getTime()){
				//Departure Time between given period
				periodS.addTail(indexNode.getData());
			}
			
			if(indexDep>=finishTime.getTime()){
				dummy(indexNode.getLeftNode(), startTime, finishTime);
			}else if(indexDep<finishTime.getTime() && indexDep>=startTime.getTime()){
				dummy(indexNode.getLeftNode(), startTime, finishTime);
				dummy(indexNode.getRightNode(), startTime, finishTime);
			}
		}
	}
	
	@Override
	public String toString(){
		SimplyLinkedList<Flights> theList=toList();
		StringBuilder listBuild=new StringBuilder();
		listBuild.append(theList);
		
		return listBuild.toString();
	}
}
