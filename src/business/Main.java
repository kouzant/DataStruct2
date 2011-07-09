package business;

import structure.BinarySearchTree;
import entities.Flights;

import java.util.Scanner;

/**
 * Κεντρική κλάση της εφαρμογής που τυπώνει το μενού, συλλέγει τις πληροφορίες
 * από το χρήστη και καλεί τις κατάλληλες μεθόδους.
 */
public class Main {

	/**
	 * Κεντρική μέθοδος που τυπώνει το μενου, συλλέγει τις πληροφορίες από το
	 * χρήστη, αρχικοποιεί μεταβλήτες και καλεί τις κατάλληλες μεθόδους.
	 * 
	 * @see BinarySearchTree#BinarySearchTree()
	 * @see Business#Business()
	 * @see Business#setBST(BinarySearchTree)
	 * @see Business#loadFlights()
	 * @see Business#addFlight(String, String, String)
	 * @see BinarySearchTree#toString()
	 * @see BinarySearchTree#delFlight(String)
	 * @see Business#searchFlight(String, String)
	 */
	public static void main(String[] args) {
		//Αντικείμενο τύπου BinarySearchTree
		BinarySearchTree<Flights> bst=new BinarySearchTree<Flights>();
		//Instance της κλάσης Business
		Business bus=new Business();
		//Ορίζει στη κλάση Business να χρησιμοποιεί το αντικειίμενο bst
		//για δυαδικό δένδρο αναζήτησης.
		bus.setBST(bst);
		//Φορτώνει ορισμένες demo πτήσεις.
		bus.loadFlights();
		//Όσο είναι true η μεταβλητή running, μετά από κάθε λειτουργία
		//τυπώνεται και το κεντρικό μενού.
		boolean running=true;
		Scanner in=new Scanner(System.in);
		while(running){
			//Τυπώνει το κεντρικό μενού.
			System.out.println(Printer.printMain());
			//Παίρνει την επιλογή του χρήστη.
			int choice=in.nextInt();
			switch(choice){
			//Περίπτωση για τη προσθήκη μιας νέας πτήσης στην εφαρμογή.
			case 1:
				Scanner inAdd=new Scanner(System.in);
				//Εκτύπωση και συλλογή πληροφοριών για τη νέα πτήση.
				System.out.println(Printer.printAddCode());
				String flightCode=inAdd.nextLine();
				System.out.println(Printer.printaddDep());
				String departureTime=inAdd.nextLine();
				System.out.println(Printer.printaddArr());
				String arrivalTime=inAdd.nextLine();
				//Κλήση μεθόδου για την οριστική προσθήκη της πτήσης στην
				//εφαρμογή
				bus.addFlight(flightCode, departureTime, arrivalTime);
				break;
			//Περίπτωση για τη προβολή όλων των πτήσεων.
			case 2:
				//Εκτύπωση του δυαδικού δένδρου αναζήτησης. Καλείται η μέθοδος
				//toString
				System.out.println(bst);
				break;
			//Περίπτωση για τη διαγραφή μιας πτήσης
			case 3:
				Scanner delFl=new Scanner(System.in);
				//Εκτύπωση του μενού για τη διαγραφή.
				System.out.println(Printer.printDel());
				//Συλλογή του κωδικού πτήσης.
				String delFlightCode=delFl.nextLine();
				//Κλήση της μεθόδου για τη διαγραφή της πτήσης από το δένδρο.
				bst.delFlight(delFlightCode);
				break;
			//Περίπτωση για την αναζήτηση του δεύτερου ερωτήματος.
			case 4:
				Scanner inSea=new Scanner(System.in);
				//Εκτύπωση και συλλογή των χρονικών στιγμών της αναζήτησης.
				System.out.println(Printer.printSearchPerA());
				String startTime=inSea.nextLine();
				System.out.println(Printer.printSearchPerB());
				String finishTime=inSea.nextLine();
				//Κλήση της μεθόδου για την αναζήτηση
				bus.searchFlight(startTime, finishTime);
				break;
			//Search the later flight
			case 5:
				Scanner inSeA=new Scanner(System.in);
				System.out.println(Printer.printSearchAf());
				String time=inSeA.nextLine();
				break;
			//Περίπτωση για την έξοδο από την εφαρμογή.
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
