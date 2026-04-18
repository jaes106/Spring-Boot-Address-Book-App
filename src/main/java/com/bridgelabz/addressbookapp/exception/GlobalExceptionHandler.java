package com.bridgelabz.addressbookapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(AddressBookNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                404,
                ex.getMessage(),
                Map.of()
        );

        return ResponseEntity.status(404).body(response);
    }

    // (Keep existing validation handler from UC11)
}