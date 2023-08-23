package com.teste.implementabiblioteca.Controller.Author.Insert;

import com.teste.implementabiblioteca.Controller.Author.Insert.DTO.DataAuthorEntity;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.DoInsertAuthor;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.ErrorSavingAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class InsertAuhtor {
    @Autowired
    private DoInsertAuthor service;

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> Insert(@RequestBody DataAuthorEntity newAuthor) {
        try {
            AuthorEntity dataAuthor = service.Insert(newAuthor.toModel());
            if (dataAuthor == null) {
                throw new ErrorSavingAuthor();
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
