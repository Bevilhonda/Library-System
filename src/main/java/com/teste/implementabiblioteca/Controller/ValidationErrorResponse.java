package com.teste.implementabiblioteca.Controller;

import java.util.List;

public class ValidationErrorResponse {
    private final List<String> errorsGenerat;

    public ValidationErrorResponse(List<String> errors) {
        this.errorsGenerat = errors;
    }
    public List<String> getErrorsGenerat() {
        return errorsGenerat;
    }
}
