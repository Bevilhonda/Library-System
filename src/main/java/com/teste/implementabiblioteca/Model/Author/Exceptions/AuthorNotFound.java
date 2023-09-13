package com.teste.implementabiblioteca.Model.Author.Exceptions;
public class AuthorNotFound extends AuthorExceptions {
    private final Integer id;
    private final String message;
    public AuthorNotFound(Integer id) {
        this.id = id;
        message = "O Autor com o id " + getId() + " não  foi encontrado.";

    }
    public Integer getId() {
        return id;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
