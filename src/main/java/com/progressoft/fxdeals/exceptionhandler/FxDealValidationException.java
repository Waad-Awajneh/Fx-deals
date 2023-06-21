package com.progressoft.fxdeals.exceptionhandler;

import java.util.Map;

public class FxDealValidationException extends RuntimeException{
    private final Map <String,String> errors;
    public FxDealValidationException(String message, Map <String,String> errors) {
        super(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
