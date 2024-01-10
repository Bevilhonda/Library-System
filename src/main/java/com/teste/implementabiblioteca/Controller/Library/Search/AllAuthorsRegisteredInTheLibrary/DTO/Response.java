package com.teste.implementabiblioteca.Controller.Library.Search.AllAuthorsRegisteredInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.util.List;

public record Response(List<AuthorsList> authors) {

    public static Response from(List<AuthorEntity> list){
        List<AuthorsList> authorsLists =
                list.stream()
                        .map(author -> AuthorsList.from(author)).toList();

        return new Response(authorsLists);
    }

}
