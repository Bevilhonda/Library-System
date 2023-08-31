package com.teste.implementabiblioteca.Model.Library.Exceptions;

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
