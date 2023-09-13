package com.teste.implementabiblioteca.Model.Book.Exceptions;

public class ErrorSavingBook extends BookExceptions {
    private final String message ;

    public ErrorSavingBook() {
        message = "Preencha os campos novamente.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
