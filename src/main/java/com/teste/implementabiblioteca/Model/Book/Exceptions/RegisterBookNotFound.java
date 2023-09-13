package com.teste.implementabiblioteca.Model.Book.Exceptions;

public class RegisterBookNotFound extends BookExceptions {
    private final String message ;

    public RegisterBookNotFound() {
        message = "Nenhum Livro foi cadastrado.";
    }

    public String getMessage() {
        return message;
    }
}
