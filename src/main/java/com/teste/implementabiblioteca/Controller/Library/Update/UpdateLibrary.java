package com.teste.implementabiblioteca.Controller.Library.Update;

import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Update.DTO.DataLibraryUpdate;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class UpdateLibrary {
    @Autowired
    private ServicesLibrary service;
    @PutMapping("/Update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id , @RequestBody DataLibraryUpdate dataLibrary){
        try {
            service.update(id,dataLibrary.toModel());
            return ResponseEntity.status(OK).build();

        } catch (LibraryExceptions e) {
            throw new RuntimeException(e);
        }
    }
}
