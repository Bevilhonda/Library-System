package com.teste.implementabiblioteca.Controller.Book.MonitorExeptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class BookNotFound extends ResponseTypeExceptions {
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
