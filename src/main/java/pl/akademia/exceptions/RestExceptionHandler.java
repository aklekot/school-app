package pl.akademia.exceptions;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {StudentNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundStudentException(RuntimeException e, WebRequest request) {
        String param = request.getParameter("lastName");
        ExceptionBody body = ExceptionBody
                .builder()
                .message(e.getMessage() + " lastName: " + param)
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {TeacherNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundTeacherException(RuntimeException e, WebRequest request) {
        String param = request.getParameter("lastName");
        ExceptionBody body = ExceptionBody
                .builder()
                .message(e.getMessage() + " lastName: " + param)
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getDescription(true))
                .timestamp(new Date().toString())
                .build();
        return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }


}