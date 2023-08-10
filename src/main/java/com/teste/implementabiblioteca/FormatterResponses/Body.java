package com.teste.implementabiblioteca.FormatterResponses;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.DataAuthorEntity;

import java.time.LocalDate;

public class Body {
    private final Integer id;
    private final Name nome;
    private final LocalDate data_nascimento;

    public Body(AuthorEntity newAuthor) {
        this.id = newAuthor.getIdAuthor();
        this.nome = new Name(newAuthor);
        this.data_nascimento = newAuthor.getDateBirth();
    }

    public Integer getId() {
        return id;
    }

    public Name getName() {
        return nome;
    }

    public LocalDate getDateBirth() {
        return data_nascimento;
    }
}
