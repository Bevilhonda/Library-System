package com.teste.implementabiblioteca.Model.Book.Exceptions;

public class BookNotFound extends BookExceptions {
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
