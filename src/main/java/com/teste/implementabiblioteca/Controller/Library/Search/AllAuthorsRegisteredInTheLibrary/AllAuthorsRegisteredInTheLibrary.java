package com.teste.implementabiblioteca.Controller.Library.Search.AllAuthorsRegisteredInTheLibrary;

import com.teste.implementabiblioteca.Controller.Library.Search.AllAuthorsRegisteredInTheLibrary.DTO.Response;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AllAuthorsRegisteredInTheLibrary {
    @Autowired
    private ServicesLibrary services;

    @GetMapping("/AllAuthorsInLibrarySelected/{name}")
    public ResponseEntity<?> getAuthorsInLibrarySelected(@PathVariable String nome) {
        try {
            List<AuthorEntity> listAuthors = services.getAllAuthorsByNameLibrary(nome);

            return ResponseEntity.status(OK).body(Response.from(listAuthors));

        } catch (Throwable e) {
            return map(e);
        }

    }
}
