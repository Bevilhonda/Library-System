package com.teste.implementabiblioteca.Controller;

import java.util.List;

public record ValidationErrorResponse(List<String> errorsGenerated) {
    public static ValidationErrorResponse fromErrors(List<String> errors) {
        return new ValidationErrorResponse(errors);
    }

}
