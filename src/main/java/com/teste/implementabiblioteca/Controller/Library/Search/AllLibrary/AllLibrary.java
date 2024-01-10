package com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary;

import com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary.DTO.Response;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AllLibrary {
    @Autowired
    private ServicesLibrary services;

    @GetMapping("/Libraries")
    public ResponseEntity<?> getAllLibrary() {
        try {
            List<LibraryEntity> listLibrary = services.getAllLibrary();

            return ResponseEntity.status(OK).body(Response.from(listLibrary));

        } catch (Throwable e) {
            return map(e);
        }
    }
}
