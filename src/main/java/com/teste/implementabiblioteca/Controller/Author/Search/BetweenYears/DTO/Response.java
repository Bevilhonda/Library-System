package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public record Response(List<Author> list) {
    public static Response from(List<AuthorEntity> authorlist) {

        List<Author> authors = authorlist.stream().map
                (author ->  Author.from(author)).toList();

        return new Response(authors);
    }
}
