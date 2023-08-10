package com.teste.implementabiblioteca.Controller.Author.FormatterResponse;

import com.teste.implementabiblioteca.FormatterResponses.Body;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFormatter {

    public static ResponseEntity<?> FormatAuthorResponse(AuthorEntity author) {
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(new Body(author));
    }
}