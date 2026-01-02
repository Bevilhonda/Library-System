package com.teste.implementabiblioteca.Controller.Book.Search.BooksInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.time.LocalDate;

public record NameBook(String title, LocalDate data_publication, Integer edicao) {

    public static NameBook from(BookEntity book){
        return new NameBook(
                book.getTitle(),
                book.getData_publication(),
                book.getEdition()
        );
    }
}
