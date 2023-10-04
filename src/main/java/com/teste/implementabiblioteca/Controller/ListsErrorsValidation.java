package com.teste.implementabiblioteca.Controller;

import java.util.List;

public record ListsErrorsValidation(List<String> errorsGenerated) {
    public static ListsErrorsValidation listErrors(List<String> errors) {
        return new ListsErrorsValidation(errors);
    }

}
