package com.teste.implementabiblioteca.Controller.Library.Search.AllAuthorsRegisteredInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

public record AuthorsList(String nome , String sobrenome) {

    public static AuthorsList from(AuthorEntity author){
         return new AuthorsList(
                 author.getName(),
                 author.getLastname());
    }
}
