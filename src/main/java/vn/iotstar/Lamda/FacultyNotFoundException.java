package vn.iotstar.Lamda;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7428051251365675318L;

	public FacultyNotFoundException(String message) {
		super(message);
	}
}