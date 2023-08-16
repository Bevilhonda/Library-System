package com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;

public class LastNameNotFound extends AuthorExceptions {

    private String sobrenome ;

    public LastNameNotFound(String lastName) {
        this.sobrenome = lastName;

    }
    public String GetLastName() {
        return sobrenome;
    }
}
