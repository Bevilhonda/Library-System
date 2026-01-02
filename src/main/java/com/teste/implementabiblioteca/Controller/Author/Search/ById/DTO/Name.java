package com.teste.implementabiblioteca.Controller.Author.Search.ById.DTO;

public record Name(String name, String lastName) {

    public static Name createName(String name, String lastName){
        return new Name(name,lastName);
    }
}
