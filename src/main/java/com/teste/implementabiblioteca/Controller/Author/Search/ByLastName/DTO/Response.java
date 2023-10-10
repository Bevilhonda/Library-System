package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public record Response(List<Author> list) {
    public static Response from(List<AuthorEntity> listAuthor) {
        List<Author> authors = listAuthor.stream().map
                (author -> Author.from(author)).toList();

        return new Response(authors);
    }
}
