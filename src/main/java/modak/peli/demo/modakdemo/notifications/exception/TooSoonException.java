package modak.peli.demo.modakdemo.notifications.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS, reason = "Rate limit exceeded")
public class TooSoonException extends RuntimeException{
}
