package com.teste.implementabiblioteca.Controller.Library.Search.ById;

import com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response;
import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ByIdLibrary {
    @Autowired
    private ServicesLibrary service;

    @GetMapping("/Library/{id}")
    public ResponseEntity<?> GetLibraryById(@PathVariable Integer id) {
        try {
            LibraryEntity library = service.getLibraryById(id);
            return ResponseEntity.status(OK).body(Response.from(library));

        } catch (LibraryExceptions e) {
            throw new RuntimeException(e);
        }
    }
}
