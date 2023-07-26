package com.teste.implementabiblioteca.MonitorExceptions;

public class NameLibraryNotFound extends ResponseTypeExceptions{

    private String nome ;
    public NameLibraryNotFound(String name){
        this.nome = name;
    }

    public String getName() {
        return nome;
    }
}
