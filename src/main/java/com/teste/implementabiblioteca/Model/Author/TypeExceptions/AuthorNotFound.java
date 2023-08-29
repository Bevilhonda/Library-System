package com.teste.implementabiblioteca.Model.Author.TypeExceptions;

public class AuthorNotFound extends AuthorExceptions {
    private Integer id;
    public AuthorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
