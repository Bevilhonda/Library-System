package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks;

import com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO.ListBook;
import com.teste.implementabiblioteca.Model.Book.Exceptions.TypeExceptions.BookExceptions;
import com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO.Response;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Model.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class AllBooks {
    @Autowired
    private ServicesBook service;

    @GetMapping("/AllBooks")
    public ResponseEntity<?> GetAllBooks(){
        try {
            List<BookEntity> listBook = service.getAllBooks();

            return ResponseEntity.status(OK).body(ListBook.from(listBook));

        } catch (BookExceptions e) {
           return MapBook(e);
        }
    }

}
