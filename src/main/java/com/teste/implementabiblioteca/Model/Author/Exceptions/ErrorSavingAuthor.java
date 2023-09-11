package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class ErrorSavingAuthor extends AuthorExceptions {
    private final String message ;

    public ErrorSavingAuthor() {
        message = "Não foi possivel salvar este autor.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
