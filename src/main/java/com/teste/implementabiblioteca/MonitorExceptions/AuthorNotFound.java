package com.teste.implementabiblioteca.MonitorExceptions;

public class AuthorNotFound extends ResponseTypeExceptions {
    private Integer id;
    public AuthorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
