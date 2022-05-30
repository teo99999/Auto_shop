package com.informatics.cscb869f2020week7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppointmentNotFoundException extends RuntimeException{

    public AppointmentNotFoundException(String message){
        super(message);
    }
}
