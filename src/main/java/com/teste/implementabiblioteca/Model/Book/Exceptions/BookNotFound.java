package com.teste.implementabiblioteca.Model.Book.Exceptions;

public class BookNotFound extends BookExceptions {
    private final Integer id;
    private final String message;
    public BookNotFound(Integer id){
        this.id= id;
        message ="O Livro com o id " + getId() + " não  foi encontrado.";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }
}
