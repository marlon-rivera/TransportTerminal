package errors;

public class TravelNotFound extends Exception{

	public TravelNotFound() {
		super("El viaje no fue encontrado");
	}
}
