package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

public record Name(String fullname) {
    public static Name createName(String fullname) {
        return new Name(fullname);
    }
}
