package com.teste.implementabiblioteca.Controller.Book.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.time.LocalDate;

public record Response
        (Integer id_Livro, Name name, Integer edicao, Integer fk_autor, LocalDate data_publication) {
    public static Response from(BookEntity book) {
        Name name = Name.createName(book.getTitle());
        return new Response(book.getIdBook(), name, book.getEdition(),
                book.getFkAuthor(), book.getData_publication());
    }
}
