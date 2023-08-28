package com.teste.implementabiblioteca.Controller.Book.Search.ById.DTO;

public class NameAuthor {

    private final String fullName;

    public NameAuthor(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
