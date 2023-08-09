package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.DAO.BookDAO;
import com.teste.implementabiblioteca.Services.Book;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBook {
    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private Book books;

    @GetMapping("/Book/{id}")
    public ResponseEntity<?> GetBookById(@PathVariable Integer id){
        return books.GetBookById(id);
    }
    @GetMapping("/AllBooks")
    public ResponseEntity<?> GetAllBooks(){
        return books.GetAllBooks();
    }
    @GetMapping("/Book/ID")
    public ResponseEntity<?> GetBookByName(@PathVariable Integer id_Livro){
        return bookDAO.GetBookByName(id_Livro);

    }

}
