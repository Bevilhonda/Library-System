package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.BetweenYears.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DAOAuthorsDateBirth {
    private final Integer id;
    private final Name nameAndLastname;
    private final LocalDate data_nascimento;

    public DAOAuthorsDateBirth(Integer id, Name nameLastname, LocalDate data_nascimento) {
        this.id = id;
        this.nameAndLastname = nameLastname;
        this.data_nascimento = data_nascimento;
    }

    public static DAOAuthorsDateBirth from(AuthorEntity author) {

        return new DAOAuthorsDateBirth(author.getIdAuthor(),
                new Name(author.getName()+ " " + author.getLastname())
                ,author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getNameAndLastname() {
        return nameAndLastname;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
