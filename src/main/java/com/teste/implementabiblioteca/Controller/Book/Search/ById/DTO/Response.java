package com.teste.implementabiblioteca.Controller.Book.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.time.LocalDate;

public class Response {

    private final Integer id_Livro;
    private final String titulo;
    private final Integer edicao;
    private final Integer fk_autor;
    private final LocalDate data_publication;

    public Response(Integer id_Livro, String titulo, Integer edicao,
                    Integer fk_autor, LocalDate data_publication) {
        this.id_Livro = id_Livro;
        this.titulo = titulo;
        this.edicao = edicao;
        this.fk_autor = fk_autor;
        this.data_publication = data_publication;
    }

    public static Response from(BookEntity book){

        return new Response(book.getIdBook(),book.geTitle(), book.getEdition(),
                book.getFkAuthor(), book.getData_publication());
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

    public LocalDate getData_publication() {
        return data_publication;
    }
}
