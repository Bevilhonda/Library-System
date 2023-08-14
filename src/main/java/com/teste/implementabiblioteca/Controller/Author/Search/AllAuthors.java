package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Services.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllAuthors {
    @Autowired
    private Author author;

    @GetMapping("/Authors")
    public ResponseEntity<?> GetAll_Authors() {
        return author.GetAllAuthor();
    }
}
