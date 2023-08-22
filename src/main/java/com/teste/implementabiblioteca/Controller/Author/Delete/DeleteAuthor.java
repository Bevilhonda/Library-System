package com.teste.implementabiblioteca.Controller.Author.Delete;


import com.teste.implementabiblioteca.Services.Author.ClassServices.DoDeleteAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;


@RestController
public class DeleteAuthor {
    @Autowired
    private DoDeleteAuthor deleteAuthor ;

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        try {
            Integer authorId = deleteAuthor.Delete(id);
            if (authorId == null){
                throw new AuthorNotFound(id);
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
