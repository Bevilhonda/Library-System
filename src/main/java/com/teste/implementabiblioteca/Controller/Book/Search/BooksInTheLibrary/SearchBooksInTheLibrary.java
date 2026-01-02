package com.teste.implementabiblioteca.Controller.Book.Search.BooksInTheLibrary;

import com.teste.implementabiblioteca.Controller.Book.Search.BooksInTheLibrary.DTO.Response;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SearchBooksInTheLibrary {
    @Autowired
    private ServicesBook servicesBook;

    @GetMapping("/SearchBooks/{id}")
    public ResponseEntity<?> getBooksInTheLibrary(@PathVariable Integer id){
        try {
            List<BookEntity> listBooks = servicesBook.getBooksByNameLibrary(id);

            return ResponseEntity.status(OK).body(Response.from(listBooks));

        }catch (Throwable e) {
            return map(e);
        }
    }
}
