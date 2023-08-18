package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ByLastName.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DAOLastName {
    private final Integer id;
    private final String name;
    private final LastName lastName;
    private final LocalDate data_nascimento;

    public DAOLastName(Integer id, String name, LastName lastname, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.lastName = lastname;
        this.data_nascimento = data_nascimento;
    }

    public static DAOLastName from(AuthorEntity author){
        return new DAOLastName(author.getIdAuthor(),author.getName(),
                new LastName(author.getLastname()),author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LastName getLastName() {
        return lastName;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
