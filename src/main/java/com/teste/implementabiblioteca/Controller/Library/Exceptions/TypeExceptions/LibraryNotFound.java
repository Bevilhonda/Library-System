package com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.LibraryExceptions;

public class LibraryNotFound extends LibraryExceptions {

    private Integer id ;
    private String nome ;
    public LibraryNotFound(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
