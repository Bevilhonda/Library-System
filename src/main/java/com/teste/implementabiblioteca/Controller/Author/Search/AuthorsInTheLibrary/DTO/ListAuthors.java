package com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

public record ListAuthors(String nome , String sobrenome) {
    public static ListAuthors from(AuthorEntity author){
         return new ListAuthors(
                 author.getName(),
                 author.getLastname());
    }
}
