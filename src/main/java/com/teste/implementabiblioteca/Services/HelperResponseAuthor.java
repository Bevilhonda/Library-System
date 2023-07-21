package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class HelperResponseAuthor {

    public static ResponseEntity<?> ReturnDetailsAuthor(String message, HttpStatus responsestatus) {

        return ResponseEntity.status(responsestatus).body(message);
    }

    public static ResponseEntity<?> DetailsAllAuthors(List<AuthorEntity> authorlist, HttpStatus currentstatus) {

        List<String> detailsauthor = new ArrayList<>();

        for (AuthorEntity author : authorlist) {

            String detailauthor = author.getIdAuthor() + " " + author.getName() + " " + author.getLastname() + " "
                    + author.getDateOfBirth();
            detailsauthor.add(detailauthor);
        }
        return ResponseEntity.status(currentstatus).body(detailsauthor);
    }
}
