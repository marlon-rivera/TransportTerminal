package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.*;

import java.time.LocalDate;
import java.util.*;

class TestTransportTerminalManager {

	private TransportTerminalManager terminalTunja;

	public TestTransportTerminalManager() {
		terminalTunja = new TransportTerminalManager();
	}

	@Test
	void Test() {
		TreeSet<Travel> travels = new TreeSet<>();
		travels.add(new Travel("Cartagena", LocalDate.of(2022, 01, 14), 200000, 86660, 6));
		LocalDate minDate = LocalDate.of(2022, 01, 10);
		LocalDate maxDate = LocalDate.of(2022, 01, 15);
		assertEquals(travels, terminalTunja.searchTravelByDestination("Cartagena", minDate, maxDate));
	}
	
	
}
