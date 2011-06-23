package business;

import structure.BinarySearchTree;
import entities.Flights;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Flights> bst=new BinarySearchTree<Flights>();
		Business bus=new Business();
		bus.setBST(bst);
		bus.loadFlights();
		boolean running=true;
		Scanner in=new Scanner(System.in);
		while(running){
			System.out.println(Printer.printMain());
			int choice=in.nextInt();
			switch(choice){
			//Add new flight
			case 1:
				Scanner inAdd=new Scanner(System.in);
				System.out.println(Printer.printAddCode());
				String flightCode=inAdd.nextLine();
				System.out.println(Printer.printaddDep());
				String departureTime=inAdd.nextLine();
				System.out.println(Printer.printaddArr());
				String arrivalTime=inAdd.nextLine();
				bus.addFlight(flightCode, departureTime, arrivalTime);
				break;
			//List flights
			case 2:
				System.out.println(bst);
				break;
			case 3:
				Scanner delFl=new Scanner(System.in);
				System.out.println(Printer.printDel());
				String delFlightCode=delFl.nextLine();
				bst.delFlight(delFlightCode);
				break;
			case 4:
				Scanner inSea=new Scanner(System.in);
				System.out.println(Printer.printSearchPerA());
				String startTime=inSea.nextLine();
				System.out.println(Printer.printSearchPerB());
				String finishTime=inSea.nextLine();
				bus.searchFlight(startTime, finishTime);
				break;
			case 5:
				Scanner inSeA=new Scanner(System.in);
				System.out.println(Printer.printSearchAf());
				String time=inSeA.nextLine();
				break;
			case 0:
				running=false;
				break;
			default:
				running=false;
				break;
			}
		}
	}

}
