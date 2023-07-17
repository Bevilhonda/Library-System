package com.teste.implementabiblioteca;

public class AutorNotFound extends ResponseTypeExceptions {
    private Integer id;
    public AutorNotFound(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
