package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.MonitorExceptions.BookNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapBook;
import static com.teste.implementabiblioteca.Services.HelperResponseBook.ReturnDetailsBook;

@Service
public class Book {
    @Autowired
    private RepositoryBook repositoryBook;

    public ResponseEntity<?> GetBookById(Integer id) {
        try {
            BookEntity book = repositoryBook.GetBook(id);

            if (book == null) {
                throw new BookNotFound(id);
            }
            return ReturnDetailsBook("Id: " + book.getIdBook() + "\n Titulo: " +
                            book.geTitle() + "\n Edição: " +
                            book.getEdition() + "\n Autor: " +
                            book.getFkAuthor() + "\n Biblioteca: " + book.getFkLibrary(),
                    HttpStatus.OK);
        } catch (ResponseTypeExceptions e) {
            return MapBook(e);
        }

    }
}
