package com.teste.implementabiblioteca.Controller.Library.Insert;

import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Insert.DTO.DataLibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertLibrary {
    @Autowired
    private ServicesLibrary service;
    @PostMapping("/Insert")
    public ResponseEntity<?> insert(@RequestBody DataLibraryEntity dataLibrary){
        try {
             service.insert(dataLibrary.toModel());

             return ResponseEntity.status(OK).build();
        } catch (Throwable e) {
            return map(e);
        }
    }
}
