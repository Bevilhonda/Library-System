package com.teste.implementabiblioteca.Controller.Book.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllBooks {
    @Autowired
    private com.teste.implementabiblioteca.Services.Book.ClassServices.AllBooks books;

    @GetMapping("/AllBooks")
    public ResponseEntity<?> GetAllBooks(){
        return books.GetAllBooks();
    }

}
