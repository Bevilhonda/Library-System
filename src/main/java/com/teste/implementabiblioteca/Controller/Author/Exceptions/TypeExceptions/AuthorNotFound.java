package com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;

public class AuthorNotFound extends AuthorExceptions {
    private Integer id;
    public AuthorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
