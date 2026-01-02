package com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public record Response(List<ListAuthors> authors) {

    public static Response from(List<AuthorEntity> list){
        List<ListAuthors> authorsLists =
                list.stream()
                        .map(ListAuthors::from).toList();

        return new Response(authorsLists);
    }

}
