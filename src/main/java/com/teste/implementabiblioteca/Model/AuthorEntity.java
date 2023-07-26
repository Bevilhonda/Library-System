package com.teste.implementabiblioteca.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "Autor")
public class AuthorEntity {

    public AuthorEntity() {
    }

    public AuthorEntity(Integer idAuthor , String name, String lastName,
                        Instant dateBirth) {
        this.nome = name;
        this.sobrenome = lastName;
        this.data_nascimento = dateBirth;
        this.id_autor = idAuthor;
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

}
