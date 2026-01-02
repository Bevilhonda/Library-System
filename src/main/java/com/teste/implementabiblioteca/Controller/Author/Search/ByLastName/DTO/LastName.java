package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

public record LastName(String lastName) {
    public static LastName createLastname(String lastName) {
        return new LastName(lastName);
    }

}
