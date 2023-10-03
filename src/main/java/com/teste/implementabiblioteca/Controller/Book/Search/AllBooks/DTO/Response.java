package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.util.List;

public class Response {

    public Response(List<Response> list) {
    }

    public static List<Book> from(List<BookEntity> list ){
        return list.stream().map(book -> new Book(book.getIdBook(),
                new Name(book.geTitle(),book.getEdition(),book.getData_publication()))).toList();
    }
}
