package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Controller.Book.DAO.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllDetailsBook {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/Book/ID")
    public ResponseEntity<?> GetBookByName(@PathVariable Integer id_Livro){
        return bookDAO.GetBookByName(id_Livro);

    }

}
