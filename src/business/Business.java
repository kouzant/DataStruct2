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
