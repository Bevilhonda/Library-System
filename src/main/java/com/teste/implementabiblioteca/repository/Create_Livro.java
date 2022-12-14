package com.teste.implementabiblioteca.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table

public class Create_Livro {
    @Id
    @GeneratedValue

    Integer id_Livro;
    String titulo;
    Integer edicao;
    Integer fk_autor;
    Integer fk_biblioteca;
    Instant data_publication;
}
