package business;

import entities.Flights;
import structure.BinarySearchTree;

import java.util.GregorianCalendar;
import java.util.Date;

public class Business {
	private BinarySearchTree<Flights> bst;
	
	public void setBST(BinarySearchTree<Flights> bst){
		this.bst=bst;
	}
	public void loadFlights(){
		Date departureTime=new GregorianCalendar(2011,05,20,10,00).getTime();
		Date arrivalTime=new GregorianCalendar(2011,05,20,11,00).getTime();
		Flights newFlight=new Flights("a",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,9,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,10,00).getTime();
		newFlight=new Flights("b",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,11,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,12,00).getTime();
		newFlight=new Flights("c",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,8,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,9,00).getTime();
		newFlight=new Flights("d",arrivalTime,departureTime);
		bst.add(newFlight);
		
		departureTime=new GregorianCalendar(2011,05,20,9,10).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,10,10).getTime();
		newFlight=new Flights("e",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,10,50).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,11,50).getTime();
		newFlight=new Flights("f",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,11,10).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,12,10).getTime();
		newFlight=new Flights("g",arrivalTime,departureTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2010,05,20,9,00).getTime();
		arrivalTime=new GregorianCalendar(2010,05,20,10,00).getTime();
		newFlight=new Flights("h",arrivalTime,departureTime);
		bst.add(newFlight);
	}
	
	public void addFlight(String flightCode, String arrTime, String depTime){
		//Split string delimited with ':'
		String[] tmpArr=arrTime.split("[:]");
		String[] tmpDep=depTime.split("[:]");
		//Create time in appropriate format
		Date arrivalTime=new GregorianCalendar(Integer.parseInt(tmpDep[0]),
				Integer.parseInt(tmpDep[1])-1, Integer.parseInt(tmpDep[2]),
				Integer.parseInt(tmpDep[3]), Integer.parseInt(tmpDep[4])).
				getTime();
		Date departureTime=new GregorianCalendar(Integer.parseInt(tmpDep[0]),
				Integer.parseInt(tmpDep[1])-1, Integer.parseInt(tmpDep[2]),
				Integer.parseInt(tmpDep[3]), Integer.parseInt(tmpDep[4])).
				getTime();
		//Create new flight instance
		Flights newFlight=new Flights(flightCode,arrivalTime,departureTime);
		//Add flight to the binary search tree
		bst.add(newFlight);
	}
}
