package structure;

import entities.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

class Node{
	private Node leftNode;
	private Node rightNode;
	private Flights data;
	
	public Node getLeftNode(){
		return leftNode;
	}
	public Node getRightNode(){
		return rightNode;
	}
	public Flights getData(){
		return data;
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
	
	Node(Flights data){
		this.leftNode=null;
		this.rightNode=null;
		this.data=data;
	}
	Node(){
		this.leftNode=null;
		this.rightNode=null;
		this.data=null;
	}
	Node(Node node){
		this.leftNode=node.getLeftNode();
		this.rightNode=node.getRightNode();
		this.data=node.getData();
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
	
	//Adds a new value to the tree
	public void add(Flights data){
		if(root==null && data!=null){
			root=new Node(data);
			System.out.println("Value "+data+" inserted at the root");
			size++;
		}else if(data!=null){
			root=add(root,data);
		}
	}
	
	//Adds a new value to the tree
	private Node add(Node index,Flights data){
		Node indexNode=new Node(index);
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
				System.out.println("Value "+data+" inserted at left child");
				size++;
			}
		}else if(compareR<0){
			if(indexNode.getRightNode()!=null){
				indexNode.setRightNode(add(indexNode.getRightNode(),data));
			}else{
				indexNode.setRightNode(new Node(data));
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
	public List<Flights> toList(){
		List<Flights> theList=new ArrayList<Flights>();
		treeToList(root,theList);
		return theList;
	}
	public void treeToList(Node indexNode, List<Flights> theList){
		if(indexNode!=null){
			treeToList(indexNode.getLeftNode(), theList);
			//System.out.println("Left Node");
			theList.add(indexNode.getData());
			treeToList(indexNode.getRightNode(), theList);
			//System.out.println("Right Node");
		}
	}
}
