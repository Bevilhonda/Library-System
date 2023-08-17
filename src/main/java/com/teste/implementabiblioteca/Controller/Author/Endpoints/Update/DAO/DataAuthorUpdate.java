package com.teste.implementabiblioteca.Controller.Author.Endpoints.Update.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DataAuthorUpdate {
    @JsonProperty("id_autor")
    private Integer idAuthor;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("sobrenome")
    private String lastname;
    @JsonProperty("data_nascimento")
    private LocalDate dateBirth;

    public DataAuthorUpdate(Integer id_autor, String name, String lastName, LocalDate dateBirth) {
        this.name = name;
        this.lastname = lastName;
        this.dateBirth = dateBirth;
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
