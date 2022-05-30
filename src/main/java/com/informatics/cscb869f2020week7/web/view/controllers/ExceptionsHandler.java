package com.informatics.cscb869f2020week7.web.view.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    protected String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/errors";
    }
}
