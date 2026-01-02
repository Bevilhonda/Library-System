package com.teste.implementabiblioteca.Controller.Author.Search.ByLastName;

import com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ByLastname {
    @Autowired
    private ServicesAuthor services;

    @GetMapping("/Author/LastName/{lastname}")
    public ResponseEntity<?> byLastName(@PathVariable String lastname) {
        try {
            List<AuthorEntity> listAuthor = services.getByLastName(lastname);

            return ResponseEntity.status(OK).body(Response.from(listAuthor));
        } catch (Throwable e) {
            return map(e);
        }

    }
}
