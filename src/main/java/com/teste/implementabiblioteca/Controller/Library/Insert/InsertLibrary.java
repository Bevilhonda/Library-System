package com.teste.implementabiblioteca.Controller.Library.Insert;

import com.teste.implementabiblioteca.Controller.Library.Insert.DTO.RequestData;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InsertLibrary {
    @Autowired
    private ServicesLibrary service;
    @PostMapping("/InsertLibrary")
    public ResponseEntity<?> insert(@RequestBody @Valid RequestData dataLibrary){
        try {
             service.insert(dataLibrary.toModel());

             return ResponseEntity.status(OK).build();
        } catch (Throwable e) {
            return map(e);
        }
    }
}
