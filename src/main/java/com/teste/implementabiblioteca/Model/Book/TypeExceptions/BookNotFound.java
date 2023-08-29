package com.teste.implementabiblioteca.Model.Book.TypeExceptions;

import com.teste.implementabiblioteca.Model.Book.TypeExceptions.BookExceptions;

public class BookNotFound extends BookExceptions {
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
