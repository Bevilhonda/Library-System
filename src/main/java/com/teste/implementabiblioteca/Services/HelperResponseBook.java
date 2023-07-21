package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class HelperResponseBook {
    public static ResponseEntity<?> ReturnDetailsBook(String message, HttpStatus responsestatus) {

        return ResponseEntity.status(responsestatus).body(message);
    }

    public static ResponseEntity<?> DetailsAllBook(List<AuthorEntity> bookList, HttpStatus currentStatus) {

        List<String> detailsBook = new ArrayList<>();

        for (AuthorEntity book : bookList) {

            String detailabBook = "Id: " + book.getIdAuthor() + "\n Nome: " +
                    book.getName() + "\n Sobrenome: " + book.getLastname()
                    + "\n Data Nascimento: " + book.getDateOfBirth();
            detailsBook.add(detailabBook);
        }
        return ResponseEntity.status(currentStatus).body(detailsBook);
    }
}
