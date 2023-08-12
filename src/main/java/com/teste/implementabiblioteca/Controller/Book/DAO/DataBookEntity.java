package com.teste.implementabiblioteca.Controller.Book.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.AuthorEntity;

import java.time.LocalDate;

public class DataBookEntity {
    @JsonProperty("id_livro")
    private Integer id_Livro;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("edicao")
    private Integer edicao;
    @JsonProperty("fk_autor")
    private Integer fk_autor;
    @JsonProperty("fk_biblioteca")
    private Integer fk_biblioteca;
    @JsonProperty("data_publication")
    private LocalDate data_publication;

    public DataBookEntity(String title, AuthorEntity author, LocalDate publicationDate, int edition, int idLibrary, int idBook) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = edition;
        this.data_publication = publicationDate;
        this.fk_autor = author.getIdAuthor();
        this.fk_biblioteca = idLibrary;

    }

    public Integer getId_Livro() {
        return id_Livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public Integer getFk_autor() {
        return fk_autor;
    }

    public Integer getFk_biblioteca() {
        return fk_biblioteca;
    }

    public LocalDate getData_publication() {
        return data_publication;
    }
}
