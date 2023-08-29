package com.teste.implementabiblioteca.Controller.Book.Delete;

import com.teste.implementabiblioteca.Model.Book.TypeExceptions.BookExceptions;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class Delete {
    @Autowired
    private ServicesBook service;
    @DeleteMapping("/Delete/Book/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            service.delete(id);
            return ResponseEntity.status(OK).build();

        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }
}
