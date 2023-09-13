package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class RegisterNotFound extends AuthorExceptions {
    private final String message ;

    public RegisterNotFound() {
        message = "Nenhum autor foi cadastrado.";
    }

    public String getMessage() {
        return message;
    }
}
