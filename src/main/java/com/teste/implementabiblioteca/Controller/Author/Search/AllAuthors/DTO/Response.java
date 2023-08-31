package com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public class Response {

    public Response(List<Author> responseList) {
    }

    public static List<Author> from(List<AuthorEntity> authorlist) {
        return authorlist.stream().map
                (author -> new Author(author.getIdAuthor(),
                        new Name(author.getName(), author.getLastname()),
                        author.getDateBirth())).toList();
    }
}
