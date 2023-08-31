package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public class Response {
    private final List<Response> list;

    public Response(List<Response> list) {
        this.list = list;
    }

    public static List<Author> from(List<AuthorEntity> listAuthor){
        return listAuthor.stream().map
                (author -> new Author(author.getIdAuthor(),author.getName(),
                        new LastName(author.getLastname()),author.getDateBirth())).toList();
    }
}
