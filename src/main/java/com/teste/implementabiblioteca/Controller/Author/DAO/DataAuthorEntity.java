package com.teste.implementabiblioteca.Controller.Author.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DataAuthorEntity {
    @JsonProperty("id_autor")
    private Integer idAuthor;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("sobrenome")
    private String lastname;
    @JsonProperty("data_nascimento")
    private LocalDate dateBirth;

    public DataAuthorEntity(Integer id_autor, String name, String lastName, String dateBirth) {
        this.name = name;
        this.lastname = lastName;
        this.dateBirth = LocalDate.parse(dateBirth);
        this.idAuthor = id_autor;
    }

    public AuthorEntity toModel() {
        return new AuthorEntity(idAuthor, name, lastname, dateBirth);
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

}


