package com.teste.implementabiblioteca.Controller.Author.Endpoints.Update;

import com.teste.implementabiblioteca.Controller.Author.DAO.DataAuthorEntity;
import com.teste.implementabiblioteca.Controller.Author.TypesResponseAuthor;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.DoUpdateAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody DataAuthorEntity novoautor) {
       try {
           AuthorEntity author = update.updateAuthor(id,novoautor.toModel());
           if (author == null){
               throw  new AuthorNotFound(id);
           }
           return TypesResponseAuthor.UpdateSucessfull(id);

       } catch (AuthorExceptions e) {
           return MapAuthor(e);
       }

    }
}
