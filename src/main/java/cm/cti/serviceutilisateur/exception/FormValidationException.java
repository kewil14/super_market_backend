package cm.cti.serviceutilisateur.exception;

public class FormValidationException extends Exception {
	private static final long serialVersionUID = 1L;
//	constructor
	public FormValidationException(String message) {
		super(message);
	}
}
