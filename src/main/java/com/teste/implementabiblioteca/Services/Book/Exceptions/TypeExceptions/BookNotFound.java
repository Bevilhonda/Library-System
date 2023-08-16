package com.teste.implementabiblioteca.Services.Book.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling.BookExceptions;

public class BookNotFound extends BookExceptions {
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
