package com.teste.implementabiblioteca.FormatterResponses;

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

    public AuthorEntity from(AuthorEntity author) {
        return new AuthorEntity(id, nome.getPrimeiro(), nome.getSegundo(), data_nascimento);
    }

    public Integer getIds() {
        return id;
    }

    public Name getNames() {
        return nome;
    }

    public LocalDate getDateBirths() {
        return data_nascimento;
    }
}
