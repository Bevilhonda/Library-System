package com.teste.implementabiblioteca.MonitorExceptions;

public class BookNotFound extends ResponseTypeExceptions{
    private Integer id;
    public BookNotFound(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }
}
