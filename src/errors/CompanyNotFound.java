package errors;

public class CompanyNotFound extends Exception {

	public CompanyNotFound() {
		super("La compania buscada no existe");
	}
}
