package com.teste.implementabiblioteca.FormatterResponses;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFormatterAuthor {

    public static ResponseEntity<?> FormatAuthorResponse(AuthorEntity author) {
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(new Body(author));
    }
}