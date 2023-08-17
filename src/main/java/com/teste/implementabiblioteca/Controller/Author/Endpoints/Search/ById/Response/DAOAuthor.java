package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ById.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DAOAuthor {

    private final Integer id;
    private final Name nome;
    private final LocalDate data_nascimento;

    public DAOAuthor(Integer id, Name nome, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public static DAOAuthor from(AuthorEntity author) {
        return new DAOAuthor(author.getIdAuthor(),
                new Name(author.getName(), author.getLastname()),
                author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getNome() {
        return nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
