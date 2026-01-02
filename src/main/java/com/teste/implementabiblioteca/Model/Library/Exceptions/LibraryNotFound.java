package com.teste.implementabiblioteca.Model.Library.Exceptions;

public class LibraryNotFound extends LibraryExceptions {

    private final Integer id ;
    private final String message;
    public LibraryNotFound(Integer id){
        this.id = id;
        message = "A Biblioteca com o id " + getId() + " não  foi encontrada.";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }
}
