package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class EmptyList extends AuthorExceptions {
    private final String message ;

    public EmptyList() {
        message = "Lista vazia";
    }

    public String getMessage() {
        return message;
    }
}
