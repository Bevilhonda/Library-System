package com.teste.implementabiblioteca.MonitorExceptions;

public class LibraryNotFound extends ResponseTypeExceptions{

    private Integer id ;
    public LibraryNotFound(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
