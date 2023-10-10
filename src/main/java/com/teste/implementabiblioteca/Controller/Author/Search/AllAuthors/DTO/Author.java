package com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public record Author (Integer id, Name name, LocalDate data_nascimento){
    public static Author from(AuthorEntity author) {
        Name name = Name.createName(author.getName(), author.getLastname());
        return  new Author(author.getIdAuthor(),name,author.getDateBirth());
    }

}
