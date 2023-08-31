package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;

public class Author {
    private final Integer id;
    private final Name nameAndLastname;
    private final LocalDate data_nascimento;

    public Author(Integer id, Name nameLastname, LocalDate data_nascimento) {
        this.id = id;
        this.nameAndLastname = nameLastname;
        this.data_nascimento = data_nascimento;
    }

    public static Author from(AuthorEntity authorEntity) {
        return new Author(authorEntity.getIdAuthor(),
                        new Name(authorEntity.getName()+ " " + authorEntity.getLastname())
                        ,authorEntity.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getNameAndLastname() {
        return nameAndLastname;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
