package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class LastNameNotFound extends AuthorExceptions {

    private final String sobrenome ;

    public LastNameNotFound(String lastName) {
        this.sobrenome = lastName;

    }
    public String GetLastName() {
        return sobrenome;
    }
}
