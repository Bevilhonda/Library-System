package com.teste.implementabiblioteca.Controller.Author.Search.ForAllAuthors.DTO;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;
import java.util.List;

public class Response {
    private final Integer id;
    private Name name;
    private final LocalDate data_nascimento;

    public Response(Integer id, Name name, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.data_nascimento = data_nascimento;
    }

    public static List<Response> from(List<AuthorEntity> authorlist) {
        return authorlist.stream().map
                (author -> new Response(author.getIdAuthor(),
                        new Name(author.getName(), author.getLastname()),
                        author.getDateBirth())).toList();
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
