package com.teste.implementabiblioteca.Controller.Author.Insert;

import com.teste.implementabiblioteca.Services.Author;
import com.teste.implementabiblioteca.Controller.Author.DAO.DataAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertAuhtor {
    @Autowired
    private Author author;

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> Insert(@RequestBody DataAuthorEntity newAuthor) {

        return author.Insert(newAuthor.toModel());
    }

}
