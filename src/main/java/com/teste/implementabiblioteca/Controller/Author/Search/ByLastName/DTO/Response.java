package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;
import java.util.List;

public class Response {
    private final Integer id;
    private final String name;
    private final LastName lastName;
    private final LocalDate data_nascimento;

    public Response(Integer id, String name, LastName lastname, LocalDate data_nascimento) {
        this.id = id;
        this.name = name;
        this.lastName = lastname;
        this.data_nascimento = data_nascimento;
    }

    public static List<Response> from(List<AuthorEntity> listAuthor){
        return listAuthor.stream().map
                (author -> new Response(author.getIdAuthor(),author.getName(),
                new LastName(author.getLastname()),author.getDateBirth())).toList();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LastName getLastName() {
        return lastName;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
}
