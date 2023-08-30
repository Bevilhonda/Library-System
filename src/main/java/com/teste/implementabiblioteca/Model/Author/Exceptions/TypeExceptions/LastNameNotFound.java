package com.teste.implementabiblioteca.Model.Author.Exceptions.TypeExceptions;

public class LastNameNotFound extends AuthorExceptions {

    private String sobrenome ;

    public LastNameNotFound(String lastName) {
        this.sobrenome = lastName;

    }
    public String GetLastName() {
        return sobrenome;
    }
}
