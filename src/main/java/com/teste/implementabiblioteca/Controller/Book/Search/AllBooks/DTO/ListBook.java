package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.util.List;

public class ListBook {
    public static List<Response> from(List<BookEntity> list ){
        return list.stream().map(book -> new Response(book.getIdBook(),
                new Name(book.geTitle(),book.getEdition(),book.getData_publication()))).toList();
    }
}
