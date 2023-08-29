package com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.DTO;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import java.time.LocalDate;
import java.util.List;

public class Response {
    private final Integer id;
    private final Name nameAndLastname;
    private final LocalDate data_nascimento;

    public Response(Integer id, Name nameLastname, LocalDate data_nascimento) {
        this.id = id;
        this.nameAndLastname = nameLastname;
        this.data_nascimento = data_nascimento;
    }

    public static List<Response> from(List<AuthorEntity> authorlist) {
        return authorlist.stream().map
                (author -> new Response(author.getIdAuthor(),
                        new Name(author.getName()+ " " + author.getLastname())
                        ,author.getDateBirth())).toList();
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
