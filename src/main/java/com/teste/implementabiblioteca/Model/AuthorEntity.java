package com.teste.implementabiblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Autor")
public class AuthorEntity {

    public AuthorEntity() {
    }

    public AuthorEntity(Integer idAuthor, String name, String lastName, LocalDate dateBirth) {
        this.id_autor = idAuthor;
        this.nome = name;
        this.sobrenome = lastName;
        this.data_nascimento = dateBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_autor")
    private Integer id_autor;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("sobrenome")
    private String sobrenome;
    @JsonProperty("data_nascimento")
    private LocalDate data_nascimento;

    public Integer getIdAuthor() {
        return id_autor;
    }

    public String getName() {
        return nome;
    }

    public String getLastname() {
        return sobrenome;
    }

    public LocalDate getDateBirth() {
        return data_nascimento;
    }
}
