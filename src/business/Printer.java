package business;
/**
 * Κλάση για την εκτύπωση των μενού της εφαρμογής.
 */
public class Printer {
	/**
	 * Μέθοδος για την εκτύπωση του κεντρικού μενού.
	 * 
	 * @return Το κεντρικό μενού σε String
	 */
	public static String printMain(){
		StringBuilder mainBuild=new StringBuilder();
		mainBuild.append("Please make your choice:");
		mainBuild.append("\n");
		mainBuild.append("1 -- Add a flight");
		mainBuild.append("\n");
		mainBuild.append("2 -- List flights");
		mainBuild.append("\n");
		mainBuild.append("3 -- Delete flight");
		mainBuild.append("\n");
		mainBuild.append("4 -- Search within a period");
		mainBuild.append("\n");
		mainBuild.append("5 -- Flight after specified time");
		mainBuild.append("\n");
		mainBuild.append("0 -- Exit");
		mainBuild.append("\n");
		
		return mainBuild.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για τη προσθήκη ενός νέου κωδικού
	 * πτήσης.
	 * 
	 * @return Το μενού για τη προσθήκη ενός νέου κωδικού πτήσης σε String.
	 */
	public static String printAddCode(){
		StringBuilder addBuildC=new StringBuilder();
		addBuildC.append("Enter the flight code:");
		addBuildC.append("\n");
		
		return addBuildC.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για τη προσθήκη μιας νέας ημερομηνίας
	 * αναχώρησης.
	 * 
	 * @return Το μενού για τη προσθήκη μιας νέας ημ/νιας αναχώρησης σε String.
	 */
	public static String printaddDep(){
		StringBuilder addBuildD=new StringBuilder();
		addBuildD.append("Enter departure time: (YYYY:MM:DD:HH:MM)");
		addBuildD.append("\n");
		
		return addBuildD.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για τη προσθήκη μιας νέας ημερομηνίας
	 * άφιξης.
	 * 
	 * @return Το μενού για τη προσθήκη μιας νέας ημ/νιας άφιξης σε String.
	 */
	public static String printaddArr(){
		StringBuilder addBuildA=new StringBuilder();
		addBuildA.append("Enter arrival time: (YYYY:MM:DD:HH:MM)");
		addBuildA.append("\n");
		
		return addBuildA.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για τη διαγραφή μιας πτήσης.
	 * 
	 * @return Το μενού για τη διαγραφή μιας πτήσης σε String.
	 */
	public static String printDel(){
		StringBuilder delBuild=new StringBuilder();
		delBuild.append("Enter flight's code:");
		delBuild.append("\n");
		
		return delBuild.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για την αναζήτηση του δεύτερου
	 * ερωτήματος.
	 * 
	 * @return Το μενού για την εκτύπωση του μενού για την αναζήτηση του 
	 * δεύτερου ερωτήματος.
	 */
	public static String printSearchPerA(){
		StringBuilder seBuild=new StringBuilder();
		seBuild.append("Enter start time: (YYYY:MM:DD:HH:MM)");
		seBuild.append("\n");
		
		return seBuild.toString();
	}
	/**
	 * Μέθοδος για την εκτύπωση του μενού για την αναζήτηση του δεύτερου
	 * ερωτήματος.
	 * 
	 * @return Το μενού για την εκτύπωση του μενού για την αναζήτηση του 
	 * δεύτερου ερωτήματος.
	 */
	public static String printSearchPerB(){
		StringBuilder seBuild=new StringBuilder();
		seBuild.append("Enter finish time: (YYYY:MM:DD:HH:MM)");
		seBuild.append("\n");
		
		return seBuild.toString();
	}
	public static String printSearchAf(){
		StringBuilder seABuild=new StringBuilder();
		seABuild.append("Enter time: (YYYY:MM:DD:HH:MM)");
		seABuild.append("\n");
		
		return seABuild.toString();
	}
}
