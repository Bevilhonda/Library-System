package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class ErrorSavingAuthor extends AuthorExceptions {
    private final String message ;

    public ErrorSavingAuthor() {
        message = "Preencha os campos novamente.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
