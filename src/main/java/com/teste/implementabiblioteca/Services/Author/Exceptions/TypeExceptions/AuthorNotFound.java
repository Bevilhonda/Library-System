package com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;

public class AuthorNotFound extends AuthorExceptions {
    private Integer id;
    public AuthorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
