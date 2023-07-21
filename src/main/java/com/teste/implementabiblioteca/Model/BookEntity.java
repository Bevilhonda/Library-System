package com.teste.implementabiblioteca.Model;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "Livro")
public class BookEntity {

    public BookEntity() {

    }

    public BookEntity(Integer idBook , String title, Integer bookEdition,
                      AuthorEntity author, LibraryEntity library, AddressEntity address,
                      Instant releaseDate) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = bookEdition;
        this.data_publication = releaseDate;
        this.fk_autor = author.getIdAuthor();
        this.fk_biblioteca = library.getIdLibrary();

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

    public Instant getReleaseDate() {
        return data_publication;
    }

    public Integer getIdBook() {
        return id_Livro;
    }
}
