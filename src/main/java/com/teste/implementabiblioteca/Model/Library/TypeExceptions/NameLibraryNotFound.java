package com.teste.implementabiblioteca.Model.Library.TypeExceptions;

import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryExceptions;

public class NameLibraryNotFound extends LibraryExceptions {

    private String nome ;
    public NameLibraryNotFound(String name){
        this.nome = name;
    }

    public String getName() {
        return nome;
    }
}
