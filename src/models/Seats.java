package models;

public class Seats {

	private int numberSeat;
	private boolean occupied;
	
	public Seats(int numberSeats, boolean occupied) {
		this.numberSeat = numberSeats;
		this.occupied = occupied;
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
	
	public void setOccupied() {
		occupied = true;
	}
	
	public int getNumberSeat() {
		return numberSeat;
	}
	
	@Override
	public String toString() {
		return numberSeat + ", Ocupada: " + occupied;
	}
}
