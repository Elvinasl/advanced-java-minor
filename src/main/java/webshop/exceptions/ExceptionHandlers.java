package webshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import webshop.exceptions.responses.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGreetingException(NotFoundException exception) {
        return ResponseEntity.ok(new ErrorResponse(exception.getMessage()));
    }
}
