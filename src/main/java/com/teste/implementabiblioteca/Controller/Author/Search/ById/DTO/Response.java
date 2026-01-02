package com.teste.implementabiblioteca.Controller.Author.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public record Response(Integer id, Name nome, LocalDate data_nascimento) {

    public static Response from(AuthorEntity author) {
        Name name = Name.createName(author.getName(),author.getLastname());

        return new Response(author.getIdAuthor(),name,author.getDateBirth());
    }
}
