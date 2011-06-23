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
	public boolean remove(Flights data, Node parent, SimplyLinkedList<Node> travDelPath){
		travDelPath.addHead(this);
		long compareR=data.getDepTime()-this.data.getDepTime();
		if(compareR>0){
			if(rightNode!=null)
				return rightNode.remove(data, this, travDelPath);
			else
				return false;
		}else if(compareR<0){
			if(leftNode!=null)
				return leftNode.remove(data, this, travDelPath);
			else
				return false;
		}else{
			if(leftNode!=null && rightNode!=null){
				this.data=rightNode.minValue();
				rightNode.remove(this.data, this, travDelPath);
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
	SimplyLinkedList<Node> travAddPath;
	SimplyLinkedList<Flights> periodS;
	SimplyLinkedList<Node> travDelPath;
	
	//Adds a new value to the tree
	public void add(Flights data){
		if(root==null && data!=null){
			root=new Node(data);
			root.setMaxArr(data.getArrTime());
			System.out.println("Value "+data+" inserted at the root");
			size++;
		}else if(data!=null){
			travAddPath=new SimplyLinkedList<Node>();
			root=add(root,data);
			
			long curArr=data.getArrTime();
			while(travAddPath.getLength()!=0){
				Node index=travAddPath.removeHead();
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
		travAddPath.addHead(indexNode);
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
	//Maybe I'll delete this method!
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
	
	public Node getNode(long index){
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
		return indexNode;
	}
	//Remove Node
	public boolean remove(Flights data){
		if(root==null){
			return false;
		}else{
			travDelPath=new SimplyLinkedList<Node>();
			if(root.getData().getDepTime()==data.getDepTime()){
				Node dummyNode=new Node(new Flights("",new Date(0),new Date(0)));
				dummyNode.setLeftNode(root);
				boolean removeRes=root.remove(data, dummyNode, travDelPath);
				root=dummyNode.getLeftNode();
				return removeRes;
			}else{
				//Get maxArr of delNode children
				Node delNode=getNode(data.getDepTime());
				long tmpMaxArr=0L;
				long tmpMaxLArr=0L;
				long tmpMaxRArr=0L;
				if(delNode.getLeftNode()!=null)
					tmpMaxLArr=delNode.getLeftNode().getMaxArr();
				if(delNode.getRightNode()!=null)
					tmpMaxRArr=delNode.getRightNode().getMaxArr();
				tmpMaxArr=(tmpMaxLArr>tmpMaxRArr)?tmpMaxLArr:tmpMaxRArr;
				
				travDelPath.addHead(root);
				boolean removeRes=root.remove(data, null, travDelPath);
				
				//Get the parent node. Second node from the
				//travDelPath
				travDelPath.removeHead();
				Node parentNode=travDelPath.getFirstNode().getValue();
				boolean switchMaxArr=false;
				
				if(tmpMaxArr>parentNode.getMaxArr())
					switchMaxArr=true;
				
				if(switchMaxArr){
					//If switchMaxArr is true then 
					//first node in the list aka parent
					//will always be smaller than tmpMaxArr due to
					//the above check
					travDelPath.removeHead().setMaxArr(tmpMaxArr);
					while(travDelPath.getLength()!=0){
						Node tmpNode=travDelPath.removeHead();
						if(tmpNode.getMaxArr()<tmpMaxArr)
							tmpNode.setMaxArr(tmpMaxArr);
					}
				}
				
				System.out.println(travDelPath);
				return removeRes;
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
		searchPeriodDep(root, startTime, finishTime);
		searchPeriodArr(root, startTime, finishTime);
		
		return periodS;
	}
	
	public Flight searchAfter(Date timestamp){
		long time=timestamp.getTime();
	}
	
	private void searchAfter(Node indexNode, long time){
		if(indexNode!=null){
			Node leftNode=indexNode.getLeftNode();
			Node rightNode=indexNode.getRightNode();
			long leftDep=leftNode.getData().getDepTime();
			long rightDep=rightNode.getData().getDepTime();
			
			if(leftDep<time && rightDep<time){
				//Check both children
				searchAfter(leftNode, time);
				searchAfter(rightNode, time);
			}else if(leftDep<time && rightDep>time){
				//Check only left child
				searchAfter(leftNode, time);
			}else if(leftDep>time && rightDep<time){
				//Check only right child
				searchAfter(rightNode, time);
			}
		}
	}
	private void searchPeriodDep(Node indexNode, Date startTime, Date finishTime){
		if(indexNode!=null){
			System.err.println(indexNode.getData().getFlightCode());
			long indexDep=indexNode.getData().getDepartureTime().getTime();
			if(indexDep>=startTime.getTime() && indexDep<=finishTime.getTime()){
				//Departure Time between given period
				periodS.addTail(indexNode.getData());
			}
			
			if(indexDep>=finishTime.getTime()){
				searchPeriodDep(indexNode.getLeftNode(), startTime, finishTime);
			}else if(indexDep<finishTime.getTime() && indexDep>=startTime.getTime()){
				searchPeriodDep(indexNode.getLeftNode(), startTime, finishTime);
				searchPeriodDep(indexNode.getRightNode(), startTime, finishTime);
			}
		}
	}
	private void searchPeriodArr(Node indexNode, Date startTime, Date finishTime){
		if(indexNode!=null){
			float indexArr=indexNode.getData().getArrivalTime().getTime();
			if(indexArr>=startTime.getTime() && indexArr<=finishTime.getTime()){
				if(!periodS.contains(indexNode.getData()))
					periodS.addTail(indexNode.getData());
			}
			searchPeriodArr(indexNode.getLeftNode(), startTime, finishTime);
			searchPeriodArr(indexNode.getRightNode(), startTime, finishTime);
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
