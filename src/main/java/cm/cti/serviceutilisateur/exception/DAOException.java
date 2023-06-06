package cm.cti.serviceutilisateur.exception;

import org.springframework.http.HttpStatus;

public class DAOException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;

	public DAOException(String message, Throwable cause) {
		//permet de donner la cause de l'erreur
		super(message, cause);

	}

	public DAOException(String messasge) {
		super(messasge);
	}
	public DAOException(String messasge, HttpStatus status) {
		super(messasge);
		this.status = status;
	}
	public DAOException(Throwable cause) {
		super(cause);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
