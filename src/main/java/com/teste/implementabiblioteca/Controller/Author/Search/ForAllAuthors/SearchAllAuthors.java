package com.teste.implementabiblioteca.Controller.Author.Search.ForAllAuthors;


import com.teste.implementabiblioteca.Controller.Author.Search.ForAllAuthors.DTO.Response;
import com.teste.implementabiblioteca.Model.AuthorEntity;

import com.teste.implementabiblioteca.Services.Author.ClassServices.DoAllAuthors;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.ListEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class SearchAllAuthors {
    @Autowired
    private DoAllAuthors author;

    @GetMapping("/Authors")
    public ResponseEntity<?> GetAll_Authors() {
        try {
            List<AuthorEntity> listAuthor = author.GetAllAuthor();

            if (listAuthor.isEmpty()) {
                throw new ListEmpty();
            }
            return Response.ListAllAuthors(listAuthor);

        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
