package views;

import java.time.LocalDate;

import javax.swing.*;

import models.*;

import java.util.*;

public class Window {

	private static final String MESSAGE_TRAVELS = "Viajes";
	private static final String TITLE_LIST_TRAVELS = "LISTA DE VIAJES";
	private static final String TITLE_MAX_DATE = "FECHA MAXIMA";
	private static final String MESSAGE_MAX_DATE = "A continucion ingrese los datos de la fecha maxima para buscar el viaje";
	private static final String TITLE_MIN_DATE = "FECHA MINIMA";
	private static final String MESSAGE_MIN_DATE = "A continucion ingrese los datos de la fecha minima para buscar el viaje";
	private static final String MESSAGE_NUMBER_SEATS = "Ingrese el numero de sillas del viaje no mayor a 20";
	private static final String TITLE_NUMBER_SEATS = "NUMERO DE SILLAS";
	private static final String MESSAGE_TRAVEL_PRICE = "Ingrese el valor del viaje";
	private static final String TITLE_TRAVEL_PRICE = "PRECIO DEL VIAJE";
	private static final String TITLE_YEAR = "ANIO";
	private static final String MESSAGE_YEAR = "Ingrese el anio del viaje";
	private static final String TITLE_MONTH = "MES";
	private static final String MESSAGE_MONTH = "Ingrese el mes del viaje";
	private static final String TITLE_DAY = "DIA";
	private static final String MESSAGE_DAY = "Ingrese el dia del viaje";
	private static final String MESSAGE_DESTINATION = "Ingrese el destino";
	private static final String TITLE_DESTINATION = "DESTINO";
	private static final String MESSAGE_COMPANY_ID = "Ingrese el id de la compania";
	private static final String TITLE_COMPANY_ID = "ID DE LA COMPANIA";
	private static final String MESSAGE_COMPANY_CODE = "Ingrese un codigo de 3 de la empresa";
	private static final String TITLE_CODE_COMPANY = "CODIGO DE LA EMPRESA";
	private static final String MESSAGE_NAME_COMPANY = "Ingrese el nombre de la compania";
	private static final String TITLE_COMPANY_NAME = "NOMBRE DE LA COMPANIA";

	public String getCompanyName() {
		return JOptionPane.showInputDialog(null, MESSAGE_NAME_COMPANY, TITLE_COMPANY_NAME, JOptionPane.QUESTION_MESSAGE);
	}
	
	public String getCompanyCode() {
		return JOptionPane.showInputDialog(null, MESSAGE_COMPANY_CODE, TITLE_CODE_COMPANY, JOptionPane.QUESTION_MESSAGE).toUpperCase();
	}
	
	public int getCompanyId() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_COMPANY_ID, TITLE_COMPANY_ID, JOptionPane.QUESTION_MESSAGE));
	}
	
	public String getDestination() {
		return JOptionPane.showInputDialog(null, MESSAGE_DESTINATION, TITLE_DESTINATION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public LocalDate getDate() {
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_DAY, TITLE_DAY, JOptionPane.QUESTION_MESSAGE));
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_MONTH, TITLE_MONTH, JOptionPane.QUESTION_MESSAGE));
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_YEAR, TITLE_YEAR, JOptionPane.QUESTION_MESSAGE));
		return LocalDate.of(year, month, day);
	}
	
	public LocalDate getMinDate() {
		JOptionPane.showMessageDialog(null, MESSAGE_MIN_DATE, TITLE_MIN_DATE, JOptionPane.QUESTION_MESSAGE);
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_DAY, TITLE_DAY, JOptionPane.QUESTION_MESSAGE));
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_MONTH, TITLE_MONTH, JOptionPane.QUESTION_MESSAGE));
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_YEAR, TITLE_YEAR, JOptionPane.QUESTION_MESSAGE));
		return LocalDate.of(year, month, day);
	}
	
	public LocalDate getMaxDate() {
		JOptionPane.showMessageDialog(null, MESSAGE_MAX_DATE, TITLE_MAX_DATE, JOptionPane.QUESTION_MESSAGE);
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_DAY, TITLE_DAY, JOptionPane.QUESTION_MESSAGE));
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_MONTH, TITLE_MONTH, JOptionPane.QUESTION_MESSAGE));
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_YEAR, TITLE_YEAR, JOptionPane.QUESTION_MESSAGE));
		return LocalDate.of(year, month, day);
	}
	
	public int getPrice() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_TRAVEL_PRICE, TITLE_TRAVEL_PRICE, JOptionPane.QUESTION_MESSAGE));
	}

	public int getNumberSeat() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, MESSAGE_NUMBER_SEATS, TITLE_NUMBER_SEATS, JOptionPane.QUESTION_MESSAGE));
	}
	
	public Travel showTravels(TreeSet<Travel> travels) {
		int option = JOptionPane.showOptionDialog(null, MESSAGE_TRAVELS, TITLE_LIST_TRAVELS,
		        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		        travels.toArray(), travels.toArray()[0]);;
		return (Travel) travels.toArray()[option];
	}
	
	public Seats showSeats(ArrayList<Seats> seat) {
		return (Seats) JOptionPane.showInputDialog(null, 
		        "Lista:", "Scrapper", JOptionPane.INFORMATION_MESSAGE,
		         null, seat.toArray(), seat.toArray()[0]);
	}
}
