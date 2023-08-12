package com.teste.implementabiblioteca.Controller.Library.MonittorExceptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class LibraryNotFound extends ResponseTypeExceptions {

    private Integer id ;
    private String nome ;
    public LibraryNotFound(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
