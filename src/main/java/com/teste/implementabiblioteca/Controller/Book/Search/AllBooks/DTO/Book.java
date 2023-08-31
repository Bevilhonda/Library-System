package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;


public class Book {
    private final Integer id;
    private final Name book;

    public Book(Integer id, Name book) {
        this.id = id;
        this.book = book;
    }

    public static Book from(BookEntity book ){
        return new Book(book.getIdBook(),
                new Name(book.geTitle(),book.getEdition(),book.getData_publication()));
    }

    public Integer getId() {
        return id;
    }

    public Name getBook() {
        return book;
    }
}
