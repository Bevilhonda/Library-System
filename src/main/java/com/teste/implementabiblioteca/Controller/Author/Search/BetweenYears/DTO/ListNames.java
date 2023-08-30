package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public class ListNames {

    public static List<Response> from(List<AuthorEntity> authorlist) {
        return authorlist.stream().map
                (author -> new Response(author.getIdAuthor(),
                        new Name(author.getName()+ " " + author.getLastname())
                        ,author.getDateBirth())).toList();
    }
}
