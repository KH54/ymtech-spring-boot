package com.example.test.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Component
public class RequestValidation {
    StringBuilder failedHistory = new StringBuilder();

    public ResponseEntity<Object> validation(BindingResult bindingResult) {
        failedHistory.setLength(0);
        for (ObjectError error : bindingResult.getAllErrors()) {
            failedHistory.append("Not valid :");
            failedHistory.append(error.getDefaultMessage());

        }
        return new ResponseEntity<>(failedHistory, HttpStatus.BAD_REQUEST);
    }
}
