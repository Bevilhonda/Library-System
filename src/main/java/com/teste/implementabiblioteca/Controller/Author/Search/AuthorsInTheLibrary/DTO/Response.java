package com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public record Response(List<AuthorsList> authors) {

    public static Response from(List<AuthorEntity> list){
        List<AuthorsList> authorsLists =
                list.stream()
                        .map(AuthorsList::from).toList();

        return new Response(authorsLists);
    }

}
