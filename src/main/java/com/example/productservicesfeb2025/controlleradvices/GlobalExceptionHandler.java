package com.example.productservicesfeb2025.controlleradvices;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)

    public ResponseEntity <String> handleProductNotFoundException(ProductNotFoundException exception) {
        //http://localhost:8080/products/40000 --> when you call this API, this error will be shown as id is invalid
        //return new ResponseEntity<>("Product with given id doesn't exist", HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public void handleArrayIndexedOutOfBound(){
//
//    }
//    @ExceptionHandler(Exception.class)
//    public void handleException() {
//
//    }

}
