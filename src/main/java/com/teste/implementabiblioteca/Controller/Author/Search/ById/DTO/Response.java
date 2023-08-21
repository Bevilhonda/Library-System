package com.teste.implementabiblioteca.Controller.Author.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class Response {

    private final Integer id;
    private final Name nome;
    private final LocalDate data_nascimento;

    public Response(Integer id, Name nome, LocalDate data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public static Response from(AuthorEntity author) {
        return new Response(author.getIdAuthor(),
                new Name(author.getName(), author.getLastname()),
                author.getDateBirth());
    }

    public Integer getId() {
        return id;
    }

    public Name getNome() {
        return nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
