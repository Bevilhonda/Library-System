package com.teste.implementabiblioteca.Controller.Book.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.BookExceptions;

public class BookNotFound extends BookExceptions {
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
