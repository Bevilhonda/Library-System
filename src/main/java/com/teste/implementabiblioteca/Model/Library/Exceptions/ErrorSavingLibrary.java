package com.teste.implementabiblioteca.Model.Library.Exceptions;

public class ErrorSavingLibrary extends LibraryExceptions {
    private final String message ;

    public ErrorSavingLibrary() {
        message = "Preencha novamente os campos.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
