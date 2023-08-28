package com.teste.implementabiblioteca.Controller.Book.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Model.BookEntity;

import java.time.LocalDate;

public class DataBookEntity {
    @JsonProperty("id_Livro")
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

    public DataBookEntity(String title, int idAuthor, LocalDate publicationDate, int edition, int idLibrary, int idBook) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = edition;
        this.fk_autor = idAuthor;
        this.fk_biblioteca = idLibrary;
        this.data_publication = publicationDate;
    }

    public BookEntity toModel() {
        return new BookEntity(titulo,fk_autor,data_publication,edicao,fk_biblioteca,id_Livro);
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
