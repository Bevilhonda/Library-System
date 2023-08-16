package com.teste.implementabiblioteca.Services.Library.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Library.Exceptions.ErrorHandling.LibraryExceptions;

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
