package com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public class Author {
    private final Integer id;
    private Name name;
    private final LocalDate data_nascimento;

    public Author(Integer id, Name name, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.data_nascimento = data_nascimento;
    }

    public static Author from(AuthorEntity author) {
        return  new Author(author.getIdAuthor(),
                        new Name(author.getName(), author.getLastname()),
                        author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
