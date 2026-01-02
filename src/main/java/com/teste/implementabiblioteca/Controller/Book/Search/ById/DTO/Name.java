package com.teste.implementabiblioteca.Controller.Book.Search.ById.DTO;

public record Name(String fullName) {
    public static Name createName(String fullName) {
        return new Name(fullName);
    }
}
