package com.teste.implementabiblioteca.Controller.Book.Insert.DTO;

import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class Insert {
    @Autowired
    private ServicesBook service;
    @PostMapping("/Insert/Book")
    public ResponseEntity<?> insert(@RequestBody DataBookEntity book){
        try {
             service.insert(book.toModel());
            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
