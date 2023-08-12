package com.teste.implementabiblioteca.Controller.Author.FormatterResponse;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class Body {
    private final Integer id;
    private final Name nome;
    private final LocalDate data_nascimento;

    public Body(Integer id, Name nome, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public static Body from(AuthorEntity author) {

        return new Body(author.getIdAuthor(),
                new Name(author.getName(), author.getLastname()), author.getDateBirth());
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
