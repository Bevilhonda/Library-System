package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.ForAllAuthors.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FormatResponseAllAuthors {
    public static ResponseEntity<?> ListAllAuthors(List<AuthorEntity> authorlist) {
        List<DAOAuthors> authorDetailsList = authorlist.stream().map
                (author -> DAOAuthors.from(author)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(authorDetailsList);
    }
}
