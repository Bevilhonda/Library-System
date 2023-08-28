package com.teste.implementabiblioteca.Controller.Book.Insert.DTO;

import com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.BookExceptions;
import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertBook {
    @Autowired
    private ServicesBook service;
    @PostMapping("/Insert/Book")
    public ResponseEntity<?> Insert(@RequestBody DataBookEntity book){
        try {
            BookEntity entity = service.insert(book.toModel());
            return ResponseEntity.status(OK).build();

        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }
}
