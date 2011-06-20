package test;

import structure.*;
import entities.Flights;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

public class Bst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		//Start of Add Test
		Date departureTime=new GregorianCalendar(2011,04,15,18,15).getTime();
		Date arrivalTime=new GregorianCalendar(2011,04,15,20,30).getTime();
		Flights flight=new Flights("ABC1234",arrivalTime,departureTime);
		BinarySearchTree<Flights> bst=new BinarySearchTree<Flights>();
		bst.add(flight);
		
		departureTime=new GregorianCalendar(2011,04,15,18,30).getTime();
		flight=new Flights("ABC5678", arrivalTime, departureTime);
		bst.add(flight);
		
		departureTime=new GregorianCalendar(2011,04,20,05,30).getTime();
		flight=new Flights("DEF1234", arrivalTime, departureTime);
		bst.add(flight);
		
		departureTime=new GregorianCalendar(2011,04,12,05,30).getTime();
		flight=new Flights("DEF5678", arrivalTime, departureTime);
		bst.add(flight);
		
		departureTime=new GregorianCalendar(2011,04,15,18,20).getTime();
		flight=new Flights("GHI1234", arrivalTime, departureTime);
		bst.add(flight);
		
		departureTime=new GregorianCalendar(2011,04,12,05,20).getTime();
		flight=new Flights("GHI5678", arrivalTime, departureTime);
		bst.add(flight);
		
		System.out.println(bst);
		//End of Add Test
		
		//Start of Get Test
		Date depTime=new GregorianCalendar(2011,04,15,18,15).getTime();
		long index=depTime.getTime();
		Flights myFlight=bst.get(index);
		System.out.println("FOUND: ");
		System.out.println(myFlight);
		//End of Get Test
		
		//Start of Remove Test
		bst.remove(myFlight);
		System.out.println(bst);
		//End of Remove Test
	}

}
