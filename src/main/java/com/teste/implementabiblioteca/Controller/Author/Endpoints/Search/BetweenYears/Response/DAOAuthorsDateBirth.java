package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.BetweenYears.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DAOAuthorsDateBirth {
    private final Integer id;
    private final String name;
    private final String lastName;
    private final LocalDate data_nascimento;

    public DAOAuthorsDateBirth(Integer id, String name, String lastName, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.data_nascimento = data_nascimento;
    }

    public static DAOAuthorsDateBirth from(AuthorEntity author) {
        return new DAOAuthorsDateBirth(author.getIdAuthor(), author.getName(),
                author.getLastname(), author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
