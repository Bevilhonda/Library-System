package com.teste.implementabiblioteca.Controller.Library.MonittorExceptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class NameLibraryNotFound extends ResponseTypeExceptions {

    private String nome ;
    public NameLibraryNotFound(String name){
        this.nome = name;
    }

    public String getName() {
        return nome;
    }
}
