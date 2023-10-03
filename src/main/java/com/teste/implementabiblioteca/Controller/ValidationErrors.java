package com.teste.implementabiblioteca.Controller;

import java.util.List;

public record ValidationErrors(List<String> errorsGenerated) {
    public static ValidationErrors listErrors(List<String> errors) {
        return new ValidationErrors(errors);
    }

}
