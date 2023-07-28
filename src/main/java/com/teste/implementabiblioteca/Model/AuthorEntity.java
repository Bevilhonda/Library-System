package com.teste.implementabiblioteca.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Autor")
public class AuthorEntity {

    public AuthorEntity() {
    }

    public AuthorEntity(Integer id_autor, String nome, String sobrenome, LocalDate data_nascimento) {
        this.id_autor = id_autor;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nascimento = data_nascimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;
    private String nome;
    private String sobrenome;
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
