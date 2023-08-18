package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ForAllAuthors.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DAOAuthors {
    private final Integer id;
    private Name name;
    private final LocalDate data_nascimento;

    public DAOAuthors(Integer id, Name name, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.data_nascimento = data_nascimento;
    }

    public static DAOAuthors from(AuthorEntity author) {
        return new DAOAuthors(author.getIdAuthor(),
                new Name(author.getName(), author.getLastname()),
                author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
