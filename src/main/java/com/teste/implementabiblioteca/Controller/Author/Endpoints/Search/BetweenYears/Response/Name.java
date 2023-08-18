package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.BetweenYears.Response;

public class Name {
    private final String fullname;

    public Name(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }
}
