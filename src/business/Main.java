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
				bus.addFlight(flightCode, arrivalTime, departureTime);
				break;
			//List flights
			case 2:
				System.out.println(bst);
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
