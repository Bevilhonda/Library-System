package com.teste.implementabiblioteca.MonitorExceptions;

public class NameLibraryNotFound extends ResponseTypeExceptions{

    private String nome ;
    public NameLibraryNotFound(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
