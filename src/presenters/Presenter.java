package presenters;

import models.*;
import views.*;
import java.util.*;

import errors.CompanyNotFound;

public class Presenter {

	private TransportTerminalManager terminalTunja;
	private Window window;
	
	public Presenter() {
		terminalTunja = new TransportTerminalManager();
		window = new Window();
		searchTravelByDestination();
	}
	
	private void addCompany() {
		terminalTunja.addCompany(window.getCompanyName(), window.getCompanyCode(), window.getCompanyId());
	}
	
	private void addTravelByCompany() {
		try {
			terminalTunja.addTravelByCompany(terminalTunja.searchCompany(window.getCompanyCode()), window.getDestination(), window.getDate(),
					window.getPrice(), window.getNumberSeat());
		} catch (CompanyNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void searchTravelByDestination() {
		TreeSet<Travel> travels = terminalTunja.searchTravelByDestination(window.getDestination(), window.getMinDate(), window.getMaxDate());
		Travel travel = window.showTravels(travels);
		Seats seat = window.showSeats(travel.getSeats());
		terminalTunja.purchaseSeat(travel, 1);
		try {
			terminalTunja.calculateEarningsByCompany(terminalTunja.searchCompany("ABC"));
		} catch (CompanyNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Presenter();
	}
}
