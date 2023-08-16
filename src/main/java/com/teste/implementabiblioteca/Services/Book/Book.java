package com.teste.implementabiblioteca.Services.Book;

import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling.BookExceptions;
import com.teste.implementabiblioteca.Services.Book.Exceptions.TypeExceptions.BookNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Book.FormatterResponse.HelperResponseBook.DetailsAllBook;
import static com.teste.implementabiblioteca.Controller.Book.FormatterResponse.HelperResponseBook.ReturnDetailsBook;
import static com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;

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
        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }

    public ResponseEntity<?> GetAllBooks() {
        List<BookEntity> books = repositoryBook.GetAllBooks();
        return DetailsAllBook(books,HttpStatus.OK);
    }
}

