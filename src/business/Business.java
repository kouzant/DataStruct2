package business;

import entities.Flights;
import structure.BinarySearchTree;
import structure.SimplyLinkedList;

import java.util.GregorianCalendar;
import java.util.Date;
/**
 * Κλάση για την κατάλληλη διαμόρφωση των δεδομένων πριν σταλούν στις μεθόδους
 * του δυαδικού δένδρου αναζήτησης. Επίσης περιέχει βοηθητικές μεθόδους.
 */
public class Business {
	//Field που δηλώνει ποιο είναι το δυαδικό δένδρο αναζήτησης για τη
	//συγκεκριμένη κλάση
	private BinarySearchTree<Flights> bst;
	
	/**
	 * Ορίζει το field bst.
	 * 
	 * @param bst Το δυαδικό δένδρο αναζήτησης που χρησιμοποιεί η εφαρμογή.
	 */
	public void setBST(BinarySearchTree<Flights> bst){
		this.bst=bst;
	}
	/**
	 * Βοηθητική μέθοδος για τη προσθήκη demo πτήσεων στο σύστημα.
	 * @see BinarySearchTree#add(Flights)
	 * @see Flights#Flights(String, Date, Date)
	 */
	public void loadFlights(){
		//Μετατροπή ημερομηνίας της μορφής YYYY:MM:DD:HH:MM σε κατάλληλη
		//μορφή για διάφορες διαδικασίες.
		Date departureTime=new GregorianCalendar(2011,05,20,10,00).getTime();
		Date arrivalTime=new GregorianCalendar(2011,05,20,11,00).getTime();
		//Δημιουργία ενός νέου instance της κλάσης Flights που αντιπροσωπεύει
		//μία πτήση.
		Flights newFlight=new Flights("a",departureTime,arrivalTime);
		//Προσθήκη της πτήσης στο δυαδικό δένδρο αναζήτησης.
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
	/**
	 * Μέθοδος για τη προσθήκη μιας νέας πτήσης στο σύστημα.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 * @param depTime Η ώρα αναχώρησης.
	 * @param arrTime Η ώρα άφιξης.
	 * @see Flights#Flights(String, Date, Date)
	 * @see BinarySearchTree#add(Flights)
	 */
	public void addFlight(String flightCode, String depTime, String arrTime){
		//Χωρίζει σε tokens την ημερομηνία αναχώρισης και άφιξης σύμφωνα με
		//συγκεκριμένο οριοθέτη.
		String[] tmpDep=depTime.split("[:]");
		String[] tmpArr=arrTime.split("[:]");
		//Μετατροπή της ημερομηνίας σε κατάλληλη μορφή για επεξεργασία.
		Date departureTime=new GregorianCalendar(Integer.parseInt(tmpDep[0]),
				Integer.parseInt(tmpDep[1])-1, Integer.parseInt(tmpDep[2]),
				Integer.parseInt(tmpDep[3]), Integer.parseInt(tmpDep[4])).
				getTime();
		Date arrivalTime=new GregorianCalendar(Integer.parseInt(tmpArr[0]),
				Integer.parseInt(tmpArr[1])-1, Integer.parseInt(tmpArr[2]),
				Integer.parseInt(tmpArr[3]), Integer.parseInt(tmpArr[4])).
				getTime();
		//Δημιουργία ενός νέου instance της κλάσης Flights που αντιπροσωπεύει
		//μία πτήση.
		Flights newFlight=new Flights(flightCode,departureTime,arrivalTime);
		//Προσθήκη της νέας πτήσης στο δυαδικό δένδρο αναζήτησης.
		bst.add(newFlight);
	}
	/**
	 * Μέθοδος για την αναζήτηση μιας πτήσης στο δυαδικό δένδρο αναζήτησης.
	 * 
	 * @param startTime Αρχή της χρονικής περιόδου.
	 * @param finishTime Τέλος της χρονικής περιόδου.
	 * @see BinarySearchTree#searchPeriod(Date, Date)
	 * @see SimplyLinkedList#toString()
	 */
	public void searchFlight(String startTime, String finishTime){
		//Χωρίζει σε tokens την ημερομηνία αναχώρισης και άφιξης σύμφωνα με
		//συγκεκριμένο οριοθέτη.
		String[] tmpSt=startTime.split("[:]");
		String[] tmpFi=finishTime.split("[:]");
		//Μετατροπή της ημερομηνίας σε κατάλληλη μορφή για επεξεργασία.
		Date startT=new GregorianCalendar(Integer.parseInt(tmpSt[0]),
				Integer.parseInt(tmpSt[1])-1, Integer.parseInt(tmpSt[2]),
				Integer.parseInt(tmpSt[3]), Integer.parseInt(tmpSt[4])).getTime();
		Date finishT=new GregorianCalendar(Integer.parseInt(tmpFi[0]),
				Integer.parseInt(tmpFi[1])-1,Integer.parseInt(tmpFi[2]),
				Integer.parseInt(tmpFi[3]), Integer.parseInt(tmpFi[4])).getTime();
		//Καλεί τη κατάλληλη μέθοδο του δυαδικού δένδρου αναζήτησης.
		//Επιστρέφει μία λίστα με τις πτήσεις.
		SimplyLinkedList<Flights> periodS=bst.searchPeriod(startT, finishT);
		//Εκτύπωση της παραπάνω λίστας. Καλείται η μέθοδος toString
		System.out.println(periodS);
	}
}
