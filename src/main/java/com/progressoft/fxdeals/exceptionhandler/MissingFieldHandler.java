package com.progressoft.fxdeals.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class MissingFieldHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FxDealValidationException.class)
    protected ResponseEntity<Object> handleMissingField(FxDealValidationException ex, WebRequest request) {
        Map<String,String> bodyOfResponse = ex.getErrors();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
