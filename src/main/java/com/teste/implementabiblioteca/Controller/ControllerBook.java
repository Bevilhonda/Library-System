package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Services.Book;
import com.teste.implementabiblioteca.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBook {
    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private Book books;

    @GetMapping("/Book/Id")
    public ResponseEntity<?> GetBookById(@RequestParam(name = "id_Livro") Integer id){
        return books.GetBookById(id);

    }
}
