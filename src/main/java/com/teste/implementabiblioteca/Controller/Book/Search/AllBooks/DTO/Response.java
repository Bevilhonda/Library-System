package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.util.List;

public record Response(List<Book> books) {
    public static Response from(List<BookEntity> list ){
        List<Book> books = list.stream().map(Book::from).toList();

        return new Response(books);
    }
}
