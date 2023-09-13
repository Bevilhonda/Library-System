package com.teste.implementabiblioteca.Model.Author.Exceptions;

import com.teste.implementabiblioteca.Model.Book.Exceptions.BookExceptions;

public class RegisterNotFound extends BookExceptions {
    private final String message ;

    public RegisterNotFound() {
        message = "Nenhum autor foi cadastrado.";
    }

    public String getMessage() {
        return message;
    }
}
