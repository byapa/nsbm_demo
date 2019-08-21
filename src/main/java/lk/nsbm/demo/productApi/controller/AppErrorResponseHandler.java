package lk.nsbm.demo.productApi.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppErrorResponseHandler {

    @ExceptionHandler({IllegalArgumentException.class, ObjectNotFoundException.class})
    public ResponseEntity<Object> handleErrors(RuntimeException ex, WebRequest request) {

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());

        // This will return a 400(not a 500)
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
