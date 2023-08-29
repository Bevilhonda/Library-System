package com.teste.implementabiblioteca.Controller.Library.Search.ByName;

import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;
import static org.springframework.http.HttpStatus.*;

@RestController
public class ByName {
    @Autowired
    private ServicesLibrary service;
    @GetMapping("/Name{name}")
    public ResponseEntity<?> GetNameLibrary(@PathVariable String name) {
        try {
            List<LibraryEntity> list = service.getLibraryByName(name);

            return ResponseEntity.status(OK).body(list);

        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }

    }
}
