package com.teste.implementabiblioteca.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Autor")
public class AuthorEntity {

    public AuthorEntity() {
    }

    public AuthorEntity(Integer id_autor , String nome, String sobrenome,
                        Instant data_nascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data_nascimento = data_nascimento;
        this.id_autor = id_autor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;
    private String nome;
    private String sobrenome;
    private Instant data_nascimento;

    public Integer getIdAuthor() {
        return id_autor;
    }

    public String getName() {
        return nome;
    }

    public String getLastname() {
        return sobrenome;
    }

    public Instant getDateOfBirth() {
        return data_nascimento;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Instant getData_nascimento() {
        return data_nascimento;
    }
}
