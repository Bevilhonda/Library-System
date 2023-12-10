package com.teste.implementabiblioteca.Controller.Author.Update;

import com.teste.implementabiblioteca.Controller.Author.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UpdateAuthor {
    @Autowired
    private ServicesAuthor service;

    @PutMapping("/UpdateAuthor/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody @Valid RequestData novoautor) {
        try {
            service.updateAuthor(id, novoautor.toModel());

            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
