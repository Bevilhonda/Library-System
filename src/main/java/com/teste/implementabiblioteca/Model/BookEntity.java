package com.teste.implementabiblioteca.Model;

import com.teste.implementabiblioteca.Autor;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "Livro")
public class BookEntity {

    public BookEntity() {

    }

    public BookEntity(String titulo, Autor autor,
                      Instant data_publication, int edicao, int id_biblioteca, int id_livro) {
        this.id_Livro = id_livro;
        this.titulo = titulo;
        this.edicao = edicao;
        this.data_publication = data_publication;
        this.fk_autor = autor.getId_autor();
        this.fk_biblioteca = id_biblioteca;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Livro;
    private String titulo;
    private Integer edicao;
    private Integer fk_autor;
    private Integer fk_biblioteca;
    private Instant data_publication;

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

    public Instant getData_publication() {
        return data_publication;
    }

    public Integer getIdBook() {
        return id_Livro;
    }
}
