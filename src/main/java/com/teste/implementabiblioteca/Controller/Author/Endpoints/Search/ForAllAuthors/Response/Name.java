package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ForAllAuthors.Response;

public class Name {
    private final String name;
    private final String lastName;

    public Name(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
