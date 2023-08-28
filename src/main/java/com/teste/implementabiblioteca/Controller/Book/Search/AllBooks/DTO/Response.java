package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.BookEntity;

import java.util.List;

public class Response {
    private final Integer id;
    private final Name book;

    public Response(Integer id, Name book) {
        this.id = id;
        this.book = book;
    }

    public static List<Response> from(List<BookEntity> list ){
        return list.stream().map(book -> new Response(book.getIdBook(),
                new Name(book.geTitle(),book.getEdition(),book.getData_publication()))).toList();
    }

    public Integer getId() {
        return id;
    }

    public Name getBook() {
        return book;
    }
}
