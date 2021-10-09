package models;

import java.time.LocalDate;
import java.util.*;

public class Travel implements Comparable<Travel> {

	private String destination;
	private LocalDate date;
	private ArrayList<Seats> listSeat;
	private int travelCode;
	private int price;
	private int numberSeats;
	private static int travelCountCode = 0;

	public Travel(String destination, LocalDate date, int price, int travelCode, int numberSeats) {
		this.destination = destination;
		this.date = date;
		this.price = price;
		listSeat = new ArrayList<>();
		fillSeats(numberSeats);
		this.travelCode = Integer.parseInt(travelCode + "" + ++travelCountCode);
	}

	@Override
	public int compareTo(Travel travel) {
		if (travel.getDate().isAfter(date)) {
			return -1;
		} else if (travel.getDate().isBefore(date)) {
			return 1;
		} else {
			return 0;
		}
	}

	public LocalDate getDate() {
		return this.date;
	}

	@Override
	public String toString() {
		return "Destino: " + destination + ", Fecha: " + date + ", Codigo de viaje: " + travelCode;
	}
	
	public int getTravelCode() {
		return this.travelCode;
	}
	
	public String getDestination() {
		return this.destination;
	}

	public ArrayList<Seats> getSeats(){
		return this.listSeat;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getNumberSeats() {
		return this.numberSeats;
	}
	
	public void fillSeats(int numberSeats) {
		for (int i = 0; i < numberSeats; i++) {
			listSeat.add(new Seats(i+1, false));
		}
	}
}