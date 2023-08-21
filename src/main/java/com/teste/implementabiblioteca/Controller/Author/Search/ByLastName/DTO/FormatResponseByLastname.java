package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FormatResponseByLastname {
    public static ResponseEntity<?> AllAuthors(List<AuthorEntity> authorlist) {
        List<Response> authorDetailsList = authorlist.stream().map
                (author -> Response.from(author)).toList();

        return ResponseEntity.status(HttpStatus.OK).body(authorDetailsList);
    }
}
