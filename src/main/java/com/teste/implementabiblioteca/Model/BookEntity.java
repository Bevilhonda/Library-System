package com.teste.implementabiblioteca.Model;

import com.teste.implementabiblioteca.Autor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;


@Entity
@Table(name = "Livro")
public class BookEntity {

    public BookEntity() {

    }

    public BookEntity(String title, AuthorEntity author, LocalDate publicationDate, int edition, int idLibrary, int idBook) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = edition;
        this.data_publication = publicationDate;
        this.fk_autor = author.getIdAuthor();
        this.fk_biblioteca = idLibrary;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Livro;
    private String titulo;
    private Integer edicao;
    private Integer fk_autor;
    private Integer fk_biblioteca;
    private LocalDate data_publication;

    public String geTitle() {
        return titulo;
    }

    public Integer getEdition() {
        return edicao;
    }

    public Integer getFkAuthor() {
        return fk_autor;
    }

    public Integer getFkLibrary() {
        return fk_biblioteca;
    }

    public LocalDate getData_publication() {
        return data_publication;
    }

    public Integer getIdBook() {
        return id_Livro;
    }
}
