package com.teste.implementabiblioteca.Controller.Book.Search.BooksInTheLibrary.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;

import java.util.List;

public record Response(List<NameBook> list) {

    public static Response from(List<BookEntity> list){
        List<NameBook> listBooks =
                list.stream()
                        .map(NameBook::from).toList();

        return new Response(listBooks);
    }
}
