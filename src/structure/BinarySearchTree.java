package structure;

import java.util.ArrayList;
import java.util.List;

class Node<E extends Comparable<? super E>>{
	private Node<E> leftNode;
	private Node<E> rightNode;
	private E data;
	
	public Node<E> getLeftNode(){
		return leftNode;
	}
	public Node<E> getRightNode(){
		return rightNode;
	}
	public E getData(){
		return data;
	}
	public void setLeftNode(Node<E> leftNode){
		this.leftNode=leftNode;
	}
	public void setRightNode(Node<E> rightNode){
		this.rightNode=rightNode;
	}
	public void setData(E data){
		this.data=data;
	}
	
	Node(E data){
		this.leftNode=null;
		this.rightNode=null;
		this.data=data;
	}
	Node(Node<E> node){
		this.leftNode=node.getLeftNode();
		this.rightNode=node.getRightNode();
		this.data=node.getData();
	}
}

public class BinarySearchTree<E extends Comparable<? super E>>{
	Node<E> root;
	int size=0;
	
	//Adds a new value to the tree
	public void add(E data){
		if(root==null && data!=null){
			root=new Node<E>(data);
			System.out.println("Value "+data+" inserted at the root");
			size++;
		}else if(data!=null){
			root=add(root,data);
		}
	}
	
	//Adds a new value to the tree
	private Node<E> add(Node<E> index,E data){
		Node<E> indexNode=new Node<E>(index);
		int compareR=indexNode.getData().compareTo(data);
		if(compareR==0)
			return indexNode;
		if(compareR>0){
			if(indexNode.getLeftNode()!=null){
				indexNode.setLeftNode(add(indexNode.getLeftNode(),data));
			}else{
				indexNode.setLeftNode(new Node<E>(data));
				System.out.println("Value "+data+" inserted at left child");
				size++;
			}
		}else if(compareR<0){
			if(indexNode.getRightNode()!=null){
				indexNode.setRightNode(add(indexNode.getRightNode(),data));
			}else{
				indexNode.setRightNode(new Node<E>(data));
				System.out.println("Value "+data+" inserted at right child");
				size++;
			}
		}
		return indexNode;
	}
	
	//Get the value of a node
	public E get(E index){
		if(root==null)
			return null;
		Node<E> indexNode=root;
		int compareR;
		while((compareR=indexNode.getData().compareTo(index))!=0){
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
	
	//BST to List
	public List<E> toList(){
		List<E> theList=new ArrayList<E>();
		treeToList(root,theList);
		return theList;
	}
	public void treeToList(Node<E> indexNode, List<E> theList){
		if(indexNode!=null){
			treeToList(indexNode.getLeftNode(), theList);
			//System.out.println("Left Node");
			theList.add(indexNode.getData());
			treeToList(indexNode.getRightNode(), theList);
			//System.out.println("Right Node");
		}
	}
}
