package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public class ListAuthors {

    public static List<Response> from(List<AuthorEntity> listAuthor){
        return listAuthor.stream().map
                (author -> new Response(author.getIdAuthor(),author.getName(),
                        new LastName(author.getLastname()),author.getDateBirth())).toList();
    }
}
