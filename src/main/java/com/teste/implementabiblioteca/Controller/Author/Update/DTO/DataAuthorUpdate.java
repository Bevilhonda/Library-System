package com.teste.implementabiblioteca.Controller.Author.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class DataAuthorUpdate {
    @JsonProperty("id_autor")
    private Integer idAuthor;
    @JsonProperty("nome")
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String name;
    @JsonProperty("sobrenome")
    @NotBlank(message = "O campo 'Sobrenome' é obrigatório.")
    private String lastname;
    @JsonProperty("data_nascimento")
    @NotNull(message = "O campo 'Data de Nascimento' é obrigatório.")
    @Past(message = "A data de nascimento inválida.")
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
