package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public record Author(Integer id, String name, LastName lastname, LocalDate data_nascimento) {

    public static Author from(AuthorEntity author) {
        LastName lastName = LastName.createLastname(author.getLastname());

        return new Author(author.getIdAuthor(), author.getName(), lastName, author.getDateBirth());
    }
}
