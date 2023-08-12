package com.teste.implementabiblioteca.Controller.Author.MonitorExceptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class AuthorNotFound extends ResponseTypeExceptions {
    private Integer id;
    public AuthorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
