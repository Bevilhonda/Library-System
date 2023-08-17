package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ByLastName.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FormatResponseByLastname {
    public static ResponseEntity<?> AllAuthors(List<AuthorEntity> authorlist) {
        List<DAOLastName> authorDetailsList = authorlist.stream().map
                (author -> DAOLastName.from(author)).toList();

        return ResponseEntity.status(HttpStatus.OK).body(authorDetailsList);
    }
}
