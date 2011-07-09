package entities;

import java.util.Date;

/**
 * Κλάση που κρατάει τις πληροφορίες των πτήσεων. Το instance της αντιπροσωπεύει
 * μία πτήση.
 */
public class Flights {
	//Ο κωδικός πτήσης
	private String flightCode;
	//Η ημερομηνία άφιξης
	private Date arrivalTime;
	//Η ημερομηνία αναχώρησης
	private Date departureTime;
	
	/**
	 * Constructor που θέτει στα private fields συγκεκριμένες τιμές.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 * @param departureTime Η ώρα αναχώρησης.
	 * @param arrivalTime Η ώρα άφιξης.
	 */
	public Flights(String flightCode, Date departureTime, Date arrivalTime){
		this.flightCode=flightCode;
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
	}
	/**
	 * Επιστρέφει τον κωδικό πτήσης.
	 * 
	 * @return Τον κωδικό πτήσης.
	 */
	public String getFlightCode(){
		return flightCode;
	}
	/**
	 * Επιστρέφει την ημερομηνία άφιξης.
	 * 
	 * @return Την ημερομηνία άφιξης.
	 */
	public Date getArrivalTime(){
		return arrivalTime;
	}
	/**
	 * Επιστρέφει την ημερομηνία αναχώρησης.
	 * 
	 * @return Την ημερομηνία αναχώρησης.
	 */
	public Date getDepartureTime(){
		return departureTime;
	}
	/**
	 * Θέτει τον κωδικό πτήσης.
	 * 
	 * @param flightCode Ο κωδικός πτήσης.
	 */
	public void setFlightCode(String flightCode){
		this.flightCode=flightCode;
	}
	/**
	 * Θέτει την ημερομηνία άφιξης.
	 * 
	 * @param arrivalTime Η ημερομηνία άφιξης.
	 */
	public void setArrivalTime(Date arrivalTime){
		this.arrivalTime=arrivalTime;
	}
	/**
	 * Θέτει την ημερομηνία αναχώρησης.
	 * 
	 * @param departureTime Η ημερομηνία αναχώρησης.
	 */
	public void setDepartureTime(Date departureTime){
		this.departureTime=departureTime;
	}
	/**
	 * Επιστρέφει την ημερομηνία αναχώρησης σε EPOCH.
	 * 
	 * @return Την ημερομηνία αναχώρησης σε EPOCH.
	 */
	public long getDepTime(){
		return departureTime.getTime();
	}
	/**
	 * Επιστρέφει την ημερομηνία άφιξης σε EPOCH.
	 * 
	 * @return Την ημερομηνία άφιξης σε EPOCH.
	 */
	public long getArrTime(){
		return arrivalTime.getTime();
	}
	/**
	 * Επιστρέφει τις λεπτομέρειες της πτήσης.
	 * 
	 * @return Τις λεπτομέρειες της πτήσης.
	 */
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n");
		sb.append("Flight Code: ");
		sb.append(flightCode).append("\n");
		sb.append("Departure Time: ");
		sb.append(departureTime).append("\n");
		sb.append("Arrival Time: ");
		sb.append(arrivalTime).append("\n");
		
		return sb.toString();
	}
}