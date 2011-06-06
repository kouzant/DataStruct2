package test;

import structure.*;
import java.util.List;

public class Bst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> bst=new BinarySearchTree<Integer>();
		bst.add(new Integer(3));
		bst.add(new Integer(2));
		bst.add(new Integer(6));
		bst.add(new Integer(1));
		bst.add(new Integer(5));
		
		List<Integer> lala=bst.toList();
		System.out.println("BST: "+lala.toString());
	}

}
