package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class ListNotFound extends AuthorExceptions {
    private final String message ;

    public ListNotFound() {
        message = "Lista vazia";
    }

    public String getMessage() {
        return message;
    }
}
