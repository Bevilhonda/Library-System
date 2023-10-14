package com.teste.implementabiblioteca.Services.Book;

import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Model.Book.Exceptions.ErrorSavingBook;
import com.teste.implementabiblioteca.Model.Book.Exceptions.RegisterBookNotFound;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServicesBook {
    @Autowired
    private RepositoryBook repository;
    public BookEntity getById(Integer id) throws BookNotFound {
        BookEntity book = repository.getBook(id);
        if (book == null){
            throw new BookNotFound(id);
        }
        return book;
    }

    public List<BookEntity> getAllBooks() throws RegisterBookNotFound {
        List<BookEntity> books = repository.getAllBooks();
        if (books.isEmpty()){
            throw new RegisterBookNotFound();
        }
        return books;
    }

    public void insert(BookEntity book) throws ErrorSavingBook {

        Integer insertData = repository.insert(book.getTitle(),book.getData_publication(),book.getEdition(),
                book.getFkAuthor(),book.getFkLibrary());
        if (insertData == null) {
            throw new ErrorSavingBook();
        }

    }
    public void update(Integer id , BookEntity book) throws BookNotFound{
        BookEntity dataBook = repository.getBook(id);
        if (dataBook == null){
            throw new BookNotFound(id);
        }

        repository.update(book.getTitle(),book.getData_publication(),
                book.getEdition(),id);
    }

    public void delete(Integer id) throws  BookNotFound {
        BookEntity dataBook = repository.getBook(id);

        if (dataBook== null){
            throw new  BookNotFound(id);
        }
        repository.delete(id);
    }
}
