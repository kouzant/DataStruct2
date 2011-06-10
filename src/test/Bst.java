package test;

import structure.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import entities.Flights;

public class Bst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Date departureTime=new GregorianCalendar(2011,04,15,18,15).getTime();
		Date arrivalTime=new GregorianCalendar(2011,04,15,20,30).getTime();
		Flights flight=new Flights("ABC1234",departureTime,arrivalTime);
		BinarySearchTree<Flights> bst=new BinarySearchTree<Flights>();*/
		BinarySearchTree<Integer> bst=new BinarySearchTree<Integer>();
		bst.add(new Integer(3));
		bst.add(new Integer(2));
		bst.add(new Integer(6));
		bst.add(new Integer(1));
		bst.add(new Integer(5));
		bst.add(new Integer(8));
		bst.add(new Integer(9));
		
		List<Integer> lala=bst.toList();
		System.out.println("BST: "+lala.toString());
		Integer fifi=bst.get(new Integer(1));
		System.out.println("Value "+fifi+" found!");
		boolean removeRes=bst.remove(new Integer(6));
		List<Integer> lala2=bst.toList();
		System.out.println("BST: "+lala2.toString());
		bst.get(new Integer(5));
	}

}
