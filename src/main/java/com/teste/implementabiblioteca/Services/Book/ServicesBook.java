package com.teste.implementabiblioteca.Services.Book;

import com.teste.implementabiblioteca.Controller.Book.Exceptions.TypeExceptions.BookNotFound;
import com.teste.implementabiblioteca.Controller.Book.Exceptions.TypeExceptions.ErrorSavingBook;
import com.teste.implementabiblioteca.Controller.Book.Exceptions.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServicesBook {
    @Autowired
    private RepositoryBook repository;
    public BookEntity getBookById(Integer id) throws BookNotFound {
        BookEntity book = repository.getBook(id);
        if (book == null){
            throw new BookNotFound(id);
        }
        return book;
    }

    public List<BookEntity> getAllBooks() throws ListEmpty {
        List<BookEntity> books = repository.getAllBooks();
        if (books.isEmpty()){
            throw new ListEmpty();
        }
        return books;
    }

    public BookEntity insert(BookEntity book) throws ErrorSavingBook {

        Integer insertData = repository.save(book.geTitle(),book.getData_publication(),book.getEdition(),
                book.getFkAuthor(),book.getFkLibrary());
        if (insertData == null) {
            throw new ErrorSavingBook();
        }
        return book;
    }
}
