package com.teste.implementabiblioteca.Controller.Library.Search.ById;

import com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.LibraryExceptions;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ByIdLibrary {
    @Autowired
    private ServicesLibrary service;

    @GetMapping("/Library/{id}")
    public ResponseEntity<?> GetLibraryById(@PathVariable Integer id) {
        try {
            LibraryEntity library = service.GetLibraryById(id);
            return ResponseEntity.status(OK).body(library);

        } catch (LibraryExceptions e) {
            throw new RuntimeException(e);
        }
    }
}
