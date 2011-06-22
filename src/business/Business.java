package business;

import entities.Flights;
import structure.BinarySearchTree;
import structure.SimplyLinkedList;

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
		Flights newFlight=new Flights("a",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,9,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,10,00).getTime();
		newFlight=new Flights("b",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,11,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,12,00).getTime();
		newFlight=new Flights("c",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,8,00).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,9,00).getTime();
		newFlight=new Flights("d",departureTime,arrivalTime);
		bst.add(newFlight);
		
		departureTime=new GregorianCalendar(2011,05,20,9,10).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,10,10).getTime();
		newFlight=new Flights("e",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,10,50).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,11,50).getTime();
		newFlight=new Flights("f",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2011,05,20,11,10).getTime();
		arrivalTime=new GregorianCalendar(2011,05,20,12,10).getTime();
		newFlight=new Flights("g",departureTime,arrivalTime);
		bst.add(newFlight);

		departureTime=new GregorianCalendar(2010,05,20,9,00).getTime();
		arrivalTime=new GregorianCalendar(2010,05,20,10,00).getTime();
		newFlight=new Flights("h",departureTime,arrivalTime);
		bst.add(newFlight);
	}
	
	public void addFlight(String flightCode, String depTime, String arrTime){
		//Split string delimited with ':'
		String[] tmpDep=depTime.split("[:]");
		String[] tmpArr=arrTime.split("[:]");
		//Create time in appropriate format
		Date departureTime=new GregorianCalendar(Integer.parseInt(tmpDep[0]),
				Integer.parseInt(tmpDep[1])-1, Integer.parseInt(tmpDep[2]),
				Integer.parseInt(tmpDep[3]), Integer.parseInt(tmpDep[4])).
				getTime();
		Date arrivalTime=new GregorianCalendar(Integer.parseInt(tmpArr[0]),
				Integer.parseInt(tmpArr[1])-1, Integer.parseInt(tmpArr[2]),
				Integer.parseInt(tmpArr[3]), Integer.parseInt(tmpArr[4])).
				getTime();
		//Create new flight instance
		Flights newFlight=new Flights(flightCode,departureTime,arrivalTime);
		//Add flight to the binary search tree
		bst.add(newFlight);
	}
	public void searchFlight(String startTime, String finishTime){
		String[] tmpSt=startTime.split("[:]");
		String[] tmpFi=finishTime.split("[:]");
		Date startT=new GregorianCalendar(Integer.parseInt(tmpSt[0]),
				Integer.parseInt(tmpSt[1])-1, Integer.parseInt(tmpSt[2]),
				Integer.parseInt(tmpSt[3]), Integer.parseInt(tmpSt[4])).getTime();
		Date finishT=new GregorianCalendar(Integer.parseInt(tmpFi[0]),
				Integer.parseInt(tmpFi[1])-1,Integer.parseInt(tmpFi[2]),
				Integer.parseInt(tmpFi[3]), Integer.parseInt(tmpFi[4])).getTime();
		SimplyLinkedList<Flights> periodS=bst.searchPeriod(startT, finishT);
		System.out.println(periodS);
	}
}
