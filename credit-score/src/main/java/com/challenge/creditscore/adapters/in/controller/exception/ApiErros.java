package com.challenge.creditscore.adapters.in.controller.exception;

import com.challenge.creditscore.application.core.exception.ScoreCreditNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErros {
    private List<String> errors;

    public ApiErros(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach( error -> this.errors.add(error.getDefaultMessage())  );
    }

    public ApiErros(ScoreCreditNotFoundException ex) {
        this.errors = Arrays.asList(ex.getMessage());
    }



    public ApiErros(ResponseStatusException ex) {
        this.errors = Arrays.asList(ex.getReason());
    }

    public List<String> getErrors() {
        return errors;
    }
}