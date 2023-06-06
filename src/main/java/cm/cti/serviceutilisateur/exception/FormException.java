package cm.cti.serviceutilisateur.exception;

import org.springframework.http.HttpStatus;

public class FormException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	public FormException(String messasge, HttpStatus status) {
		super(messasge);
//		permet de savoir si c'est genre 401, 403,5000 etc
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
