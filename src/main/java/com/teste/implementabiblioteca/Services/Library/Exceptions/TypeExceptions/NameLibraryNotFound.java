package com.teste.implementabiblioteca.Services.Library.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Library.Exceptions.ErrorHandling.LibraryExceptions;

public class NameLibraryNotFound extends LibraryExceptions {

    private String nome ;
    public NameLibraryNotFound(String name){
        this.nome = name;
    }

    public String getName() {
        return nome;
    }
}
