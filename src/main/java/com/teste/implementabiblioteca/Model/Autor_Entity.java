package com.teste.implementabiblioteca.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "Autor")
public class Autor_Entity {

    public Autor_Entity(String nome, String sobrenome, Instant data_nascimento) {
        nome = nome;
        data_nascimento = data_nascimento;
        sobrenome = sobrenome;
    }

    @Id
    @GeneratedValue
    Integer id_autor;

    String nome;

    String sobrenome;

    Instant data_nascimento;

    public Autor_Entity() {
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
