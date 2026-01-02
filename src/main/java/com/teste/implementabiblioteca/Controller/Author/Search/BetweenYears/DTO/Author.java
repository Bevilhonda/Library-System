package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public record Author(Integer id, Name nameLastname, LocalDate data_nascimento) {

    public static Author from(AuthorEntity authorEntity) {
        Name name = Name.createName(authorEntity.getName());

        return new Author(authorEntity.getIdAuthor(), name, authorEntity.getDateBirth());
    }
}
