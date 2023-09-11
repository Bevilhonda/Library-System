package com.teste.implementabiblioteca.Model.Book.Exceptions;

public class ErrorSavingBook extends BookExceptions {
    private String message ;

    public ErrorSavingBook() {
        message = "Não foi possivel inserir o Livro.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
