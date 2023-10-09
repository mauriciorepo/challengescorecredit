package com.challenge.creditscore.adapters.in.controller;

import com.challenge.creditscore.adapters.in.controller.exception.ApiErros;
import com.challenge.creditscore.application.core.exception.ScoreCreditNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationExceptions(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        return new ApiErros(bindingResult);
    }

    @ExceptionHandler(ScoreCreditNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handleBusinessException(ScoreCreditNotFoundException ex){

        return new ApiErros(ex);
    }


}
