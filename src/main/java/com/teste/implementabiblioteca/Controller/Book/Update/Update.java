package com.teste.implementabiblioteca.Controller.Book.Update;

import com.teste.implementabiblioteca.Model.Book.TypeExceptions.BookExceptions;
import com.teste.implementabiblioteca.Controller.Book.Insert.DTO.DataBookEntity;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class Update {
    @Autowired
    private ServicesBook service;
    @PutMapping("/Update/Book{id}")
    public ResponseEntity<?> update(@PathVariable Integer id ,@RequestBody DataBookEntity book){
        try {
            service.update(id, book.toModel());

            return ResponseEntity.status(OK).build();
        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }
}
