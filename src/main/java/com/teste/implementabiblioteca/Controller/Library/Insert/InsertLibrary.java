package com.teste.implementabiblioteca.Controller.Library.Insert;

import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Insert.DTO.DataLibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertLibrary {
    @Autowired
    private ServicesLibrary service;
    @PostMapping("/Insert/Library")
    public ResponseEntity<?> Insert(@RequestBody DataLibraryEntity dataLibrary){
        try {
             service.insert(dataLibrary.toModel());

             return ResponseEntity.status(OK).build();
        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }
    }
}
