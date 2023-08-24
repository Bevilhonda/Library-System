package com.teste.implementabiblioteca.Services.Book.ClassServices;

import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Book.FormatterResponse.HelperResponseBook.DetailsAllBook;
@Service
public class DoAllBooks {
    @Autowired
    private RepositoryBook repositoryBook;

    public ResponseEntity<?> GetAllBooks() {
        List<BookEntity> books = repositoryBook.GetAllBooks();
        return DetailsAllBook(books, HttpStatus.OK);
    }
}
