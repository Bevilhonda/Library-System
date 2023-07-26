package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Model.BookEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class HelperResponseBook {
    public static ResponseEntity<?> ReturnDetailsBook(String message, HttpStatus responsestatus) {

        return ResponseEntity.status(responsestatus).body(message);
    }

    public static ResponseEntity<?> DetailsAllBook(List<BookEntity> bookList, HttpStatus currentStatus) {

        List<String> detailsBook = new ArrayList<>();

        for (BookEntity book : bookList) {

            String detailabBook =
                    "Id: " + book.getIdBook() + " Biblioteca " + book.getFkLibrary() +
                            " Titulo: " + book.geTitle() + " Edição: " + book.getEdition()
                            + " Data Publicação: " + book.getData_publication() + " Autor: " +
                            book.getFkAuthor();
            detailsBook.add(detailabBook);
        }
        return ResponseEntity.status(currentStatus).body(detailsBook);
    }
}
