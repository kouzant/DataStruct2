package entities;

import java.util.Date;

public class Flights {
	private String flightCode;
	private Date arrivalTime;
	private Date departureTime;
	
	public Flights(String flightCode, Date arrivalTime, Date departureTime){
		this.flightCode=flightCode;
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
	}

	public String getFlightCode(){
		return flightCode;
	}
	public Date getArrivalTime(){
		return arrivalTime;
	}
	public Date getDepartureTime(){
		return departureTime;
	}
	public void setFlightCode(String flightCode){
		this.flightCode=flightCode;
	}
	public void setArrivalTime(Date arrivalTime){
		this.arrivalTime=arrivalTime;
	}
	public void setDepartureTime(Date departureTime){
		this.departureTime=departureTime;
	}
	public long getDepTime(){
		return departureTime.getTime();
	}
	public long getArrTime(){
		return arrivalTime.getTime();
	}
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