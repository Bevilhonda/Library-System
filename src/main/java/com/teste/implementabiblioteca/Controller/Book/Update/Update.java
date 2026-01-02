package com.teste.implementabiblioteca.Controller.Book.Update;

import com.teste.implementabiblioteca.Controller.Book.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Book.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Update {
    @Autowired
    private ServicesBook service;
    @PutMapping("/UpdateBook/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id ,@RequestBody @Valid RequestData book){
        try {
            service.update(id, book.toModel());

            return ResponseEntity.status(OK).build();
        } catch (Throwable e) {
            return map(e);
        }
    }
}
