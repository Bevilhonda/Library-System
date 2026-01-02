package com.teste.implementabiblioteca.Model.Library.Exceptions;

public class NameLibraryNotFound extends LibraryExceptions {

    private final String nome ;
    private final String message;
    public NameLibraryNotFound(String name){
        this.nome = name;
        message = "A Biblioteca com o nome " + getName() + " não  foi encontrada.";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getName() {
        return nome;
    }
}
