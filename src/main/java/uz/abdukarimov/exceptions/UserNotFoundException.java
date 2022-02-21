package uz.abdukarimov.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class UserNotFoundException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public UserNotFoundException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public UserNotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
