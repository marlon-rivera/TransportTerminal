package models;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import errors.CompanyNotFound;
import errors.TravelNotFound;

import java.time.*;

public class TransportTerminalManager {

	private HashMap<String, Company> listCompany;

	public TransportTerminalManager() {
		listCompany = new HashMap<>();
		listCompany.put("ABC", new Company("ABC TRANSPORTE", 75550));
		listCompany.put("DEF", new Company("DEF TRANSPORTE", 86660));
		listCompany.put("GHI", new Company("GHI TRANSPORTE", 97770));
		
		try {
			addTravelByCompany(searchCompany("ABC"), "Cartagena", LocalDate.of(2021, 05, 14), 5000, 6);
			addTravelByCompany(searchCompany("ABC"), "Santa Marta", LocalDate.of(2021, 03, 14), 25000, 3);
			addTravelByCompany(searchCompany("ABC"), "Cucuta", LocalDate.of(2022, 02, 14), 3000, 7);
			addTravelByCompany(searchCompany("ABC"), "Bucaramanga", LocalDate.of(2022, 01, 14), 2000, 8);
			addTravelByCompany(searchCompany("DEF"), "Cartagena", LocalDate.of(2022, 01, 14), 1000, 6);
			addTravelByCompany(searchCompany("GHI"), "Monteria", LocalDate.of(2024, 01, 14), 2000, 6);
			addTravelByCompany(searchCompany("GHI"), "Cartagena", LocalDate.of(2020, 01, 14), 3000, 5);
			addTravelByCompany(searchCompany("GHI"), "Medellin", LocalDate.of(2020, 01, 15), 3000, 7);
			addTravelByCompany(searchCompany("DEF"), "Cartagena", LocalDate.of(2022, 02, 14), 4000, 6);
		} catch (CompanyNotFound e) {
			e.printStackTrace();
		}
		
		try {
			purchaseSeat(searchTravel(searchCompany("ABC"), 755504), 1);
		} catch (TravelNotFound | CompanyNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addCompany(String name, int id) {
		listCompany.put(getCodeFromName(name).toUpperCase(), new Company(name, id));
	}

	public void addTravelByCompany(Company company, String destination, LocalDate date, int price, int numberSeats) {
		company.addTravel(destination, date, price, company.getIdNumber(), numberSeats);
	}
	
	public boolean purchaseSeat(Travel travel, int numberSeat) {
		ArrayList<Seats> seats = travel.getSeats();
		System.out.println(travel);
		for (int i = 0; i < seats.size(); i++) {
			if(seats.get(i).getNumberSeat() == numberSeat) {
				seats.get(i).setOccupied();
				return true;
			}
		}
		return false;
	}
	
	public TreeSet<Travel> searchTravelByDestination(String destination, LocalDate minDate, LocalDate maxDate) {
		TreeSet<Travel> travels = new TreeSet<>();
		ArrayList<String> keys = new ArrayList<>(listCompany.keySet());
		for (int i = 0; i < keys.size(); i++) {
			TreeSet<Travel> travelsByCompany = listCompany.get(keys.get(i)).getTravels();
			for (Travel travel : travelsByCompany) {
				if(travel.getDestination().equals(destination) && travel.getDate().isAfter(minDate) && travel.getDate().isBefore(maxDate)) {
					travels.add(travel);
				}
			}
		}
		return travels;
	}

	public String[][] calculateEarnings(){
		String [][] report = new String[listCompany.size()][2]; 
		ArrayList<Company> companyNames = new ArrayList<>(listCompany.values());
		for (int i = 0; i < report.length; i++) {
			report[i][0] = companyNames.get(i).toString();
		}
		for (int i = 0; i < report.length; i++) {
			report[i][1] = " : " + calculateEarningsByCompany(companyNames.get(i));
		}
		return report;
	}
	
	public int calculateEarningsByCompany(Company company) {
		int total = 0;
		TreeSet<Travel> travels = company.getTravels();
		for (Travel travel : travels) {
			ArrayList<Seats> seats = travel.getSeats();
			for (int i = 0; i < seats.size(); i++) {
				if(seats.get(i).isOccupied()) {
					total += travel.getPrice();
				}
			}
		}
		return total;
	}
	
	public Travel searchTravel(Company company, int codeTravel) throws TravelNotFound {
		TreeSet<Travel> travels = company.getTravels();
		for (Travel travel : travels) {
			if(travel.getTravelCode() == codeTravel) {
				return travel;
			}
		}
		throw new TravelNotFound();
	}

	public Company searchCompany(String key) throws CompanyNotFound {	
		Company company = listCompany.get(key);
		if(company != null) {
			return company;
		}
		throw new CompanyNotFound();
	}
	
	public HashMap<String, Company> getCompanyList(){
		return this.listCompany;
	}
	
 	public TreeSet<Company> orderCompanyByNumberSeatsAvalaibles(){
 		TreeSet<Company> companies = new TreeSet<>();
 		ArrayList<Company> values = new ArrayList<>(listCompany.values());
 		for (int i = 0; i < values.size(); i++) {
 			//System.out.println(values.get(i));
			companies.add(values.get(i));
		}
 		return companies;
 	}
	
	public String getCodeFromName(String name) {
		String code = "";
		Pattern pattern = Pattern.compile("([a-zA-Z0-9]){3}");
		Matcher matcher = pattern.matcher(name);
		while (matcher.find()) {
			code = matcher.group();
			break;
		}
		return code;
	}
	
	public void print(Company company) {
		TreeSet<Company> companies = orderCompanyByNumberSeatsAvalaibles();
		for (Company company2 : companies) {
			System.out.println(company2);
		}
	}
	
	public static void main(String[] args) {
		TransportTerminalManager ttm = new TransportTerminalManager();
		System.out.println(ttm.getCodeFromName("Omega"));
		try {
			ttm.print(ttm.searchCompany("DEF"));
		} catch (CompanyNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}