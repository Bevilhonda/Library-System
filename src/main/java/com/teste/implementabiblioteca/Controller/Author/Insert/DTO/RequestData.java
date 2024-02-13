package com.teste.implementabiblioteca.Controller.Author.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class RequestData {
    @JsonProperty("id_autor")
    private Integer idAuthor;
    @JsonProperty("nome")
    @NotBlank(message = "Digite o nome do Autor.")
    private String name;
    @JsonProperty("sobrenome")
    @NotBlank(message = "Digite o sobrenome do Autor.")
    private String lastname;
    @JsonProperty("data_nascimento")
    @NotNull(message = "A Data de Nascimento é obrigatória.")
    @Past(message = "A data de nascimento não pode ser no futuro.")
    private LocalDate dateBirth;

    public RequestData(String name, String lastname, LocalDate dateBirth) {
        this.name = name;
        this.lastname = lastname;
        this.dateBirth = dateBirth;
    }


    public AuthorEntity toModel() {
        return new AuthorEntity(idAuthor, name, lastname, dateBirth);
    }

}


