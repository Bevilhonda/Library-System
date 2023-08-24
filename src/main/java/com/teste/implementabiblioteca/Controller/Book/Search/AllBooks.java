package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Services.Book.ClassServices.DoAllBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllBooks {
    @Autowired
    private DoAllBooks books;

    @GetMapping("/AllBooks")
    public ResponseEntity<?> GetAllBooks(){
        return books.GetAllBooks();
    }

}
