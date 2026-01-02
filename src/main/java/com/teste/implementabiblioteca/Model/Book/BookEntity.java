package com.teste.implementabiblioteca.Model.Book;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Livro")
public class BookEntity {

    public BookEntity() {

    }

    public BookEntity(String title,LocalDate data_publication,Integer edicao,Integer fk_autor,
                      Integer fk_biblioteca, Integer idBook) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = edicao;
        this.data_publication = data_publication;
        this.fk_autor = fk_autor;
        this.fk_biblioteca = fk_biblioteca;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Livro;
    private String titulo;
    private Integer edicao;
    private Integer fk_autor;
    private Integer fk_biblioteca;
    private LocalDate data_publication;

    public String getTitle() {
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
