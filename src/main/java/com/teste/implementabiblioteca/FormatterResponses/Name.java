package com.teste.implementabiblioteca.FormatterResponses;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.DataAuthorEntity;

public class Name {
    private final String primeiro;
    private final String segundo;

    public Name(AuthorEntity author) {
        this.primeiro = author.getName();
        this.segundo = author.getLastname();
    }

    public String getPrimeiro() {
        return primeiro;
    }

    public String getSegundo() {
        return segundo;
    }
}
