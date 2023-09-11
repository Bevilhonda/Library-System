package com.teste.implementabiblioteca.Model.Library.Exceptions;

public class ErrorSavingLibrary extends LibraryExceptions {
    private final String message ;

    public ErrorSavingLibrary() {
        message = "Não foi possivel inserir o autor.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
