package com.teste.implementabiblioteca.Model.Author.Exceptions;

import lombok.Getter;

public class AuthorNotFound extends AuthorExceptions {

    @Getter
    private final Integer id;
    private final String message;

    public AuthorNotFound(Integer id) {
        this.id = id;
        message = "O Autor com o id " + getId() + " não foi encontrado.";

    }

    @Override
    public String getMessage() {
        return message;
    }
}
