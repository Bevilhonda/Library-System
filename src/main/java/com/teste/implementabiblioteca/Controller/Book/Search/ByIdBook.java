package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Services.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByIdBook {
    @Autowired
    private Book books;

    @GetMapping("/Book/{id}")
    public ResponseEntity<?> GetBookById(@PathVariable Integer id){
        return books.GetBookById(id);
    }

}
