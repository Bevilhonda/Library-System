package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ById.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FormatResponseById {
    public static ResponseEntity<?> responseById(AuthorEntity author){
        return ResponseEntity.status(HttpStatus.OK).body(DAOAuthor.from(author));
    }
}
