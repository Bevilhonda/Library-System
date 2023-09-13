package com.teste.implementabiblioteca.Model.Author.Exceptions;

public class LastNameNotFound extends AuthorExceptions {

    private final String message;
    private final String lastName;

    public LastNameNotFound(String lastName) {
        this.lastName = lastName;
        message = "Não foi encontrado nenhum autor com o sobrenome " + getLastName();

    }
    @Override
    public String getMessage() {
        return message;
    }

    public String getLastName() {
        return lastName;
    }
}
