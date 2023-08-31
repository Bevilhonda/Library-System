package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public class Response {
    private final List<Response> list;

    public Response(List<Response> list) {
        this.list = list;
    }

    public static List<Author> from(List<AuthorEntity> authorlist) {
        return authorlist.stream().map
                (author -> new Author(author.getIdAuthor(),
                        new Name(author.getName()+ " " + author.getLastname())
                        ,author.getDateBirth())).toList();
    }
}
