package com.teste.implementabiblioteca.Controller.Book.Delete;

import com.teste.implementabiblioteca.Services.Book.ClassServices.BookDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteBook {
    @Autowired
    private BookDelete book;
    @DeleteMapping("/Delete/Book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id){
        return deleteBook(id);
    }
}
