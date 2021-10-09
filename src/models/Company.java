package models;

import java.util.*;
import java.time.*;

public class Company implements Comparable<Company> {

	private String name;
	private int idNumber;
	private TreeSet<Travel> travels;

	public Company(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
		travels = new TreeSet<>();
	}

	public void addTravel(String destination, LocalDate date, int price, int travelCode, int numberSeats) {
		travels.add(new Travel(destination, date, price, travelCode, numberSeats));
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	public TreeSet<Travel> getTravels() {
		return travels;
	}
	
	@Override
	public int compareTo(Company company) {
		if(getNumberSeatsAvalibles() > company.getNumberSeatsAvalibles()) {
			return -1;
		}else if(getNumberSeatsAvalibles() < company.getNumberSeatsAvalibles()) {
			return 1;
		}else {
			return 0;	
		}
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public int getNumberSeatsAvalibles() {
		int totalSeats = 0;
		ArrayList<Seats> seats = new ArrayList<>();
		for (Travel travel : travels) {
			seats = travel.getSeats();
			for (int i = 0; i < seats.size(); i++) {
				if(!seats.get(i).isOccupied()) {
					totalSeats++;
				}
			}
		}
		return totalSeats;
	}
	
	@Override
	public String toString() {
		return name + " - " + getNumberSeatsAvalibles();
	}
}
