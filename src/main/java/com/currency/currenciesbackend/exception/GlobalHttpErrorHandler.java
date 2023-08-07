package com.currency.currenciesbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler {

    @ExceptionHandler(CreateCurrencyUserQueryException.class)
    public ResponseEntity<Object> handleCreateCurrencyUserQueriesExcpetion() {
        return new ResponseEntity<>("Bad currencyCode",
                HttpStatus.BAD_REQUEST);
    }
}
