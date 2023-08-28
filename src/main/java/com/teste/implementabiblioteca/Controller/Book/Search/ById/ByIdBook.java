package com.teste.implementabiblioteca.Controller.Book.Search.ById;

import com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.BookExceptions;
import com.teste.implementabiblioteca.Controller.Book.Exceptions.TypeExceptions.BookNotFound;
import com.teste.implementabiblioteca.Controller.Book.Search.ById.DTO.Response;
import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class ByIdBook {
    @Autowired
    private ServicesBook service;

    @GetMapping("/Book/{id}")
    public ResponseEntity<?> GetBookById(@PathVariable Integer id){
        try {
           BookEntity book = service.getBookById(id);

            return ResponseEntity.status(OK).body(Response.from(book));

        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }

}
