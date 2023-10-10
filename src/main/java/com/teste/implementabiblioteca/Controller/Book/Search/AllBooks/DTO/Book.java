package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import com.teste.implementabiblioteca.Model.Book.BookEntity;


public record Book (Integer id, Name book){
    public static Book from(BookEntity book ){
        Name name = Name.createName(book.geTitle(),book.getEdition(),book.getData_publication());
        return new Book(book.getIdBook(), name);
    }
}
