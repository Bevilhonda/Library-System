package com.teste.implementabiblioteca.Controller.Author.Endpoints.Search.BetweenYears.Response;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FormatResponseDateBirth {
    public static ResponseEntity<?> AllAuthorsByDateBirth(List<AuthorEntity> authorlist) {
        List<DAOAuthorsDateBirth> authorDetailsList = authorlist.stream().map
                (author -> DAOAuthorsDateBirth.from(author)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(authorDetailsList);
    }

}
