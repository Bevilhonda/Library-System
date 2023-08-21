package com.teste.implementabiblioteca.Controller.Author.Update;

import com.teste.implementabiblioteca.Controller.Author.Update.DTO.DataAuthorUpdate;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.DoUpdateAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class UpdateAuthor {
    @Autowired
    private DoUpdateAuthor update;

    @PutMapping("/UpdateAuthor/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody DataAuthorUpdate novoautor) {
        try {
            AuthorEntity author = update.updateAuthor(id, novoautor.toModel());
            if (author == null) {
                throw new AuthorNotFound(id);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Ok");

        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }
}
