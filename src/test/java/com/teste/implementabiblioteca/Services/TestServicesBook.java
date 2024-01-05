package com.teste.implementabiblioteca.Services;


import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Model.Book.Exceptions.RegisterBookNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DataJpaTest
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestServicesBook {
    @Autowired
    private ServicesBook services;

    @Test
    void insert() {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        BookEntity book = new BookEntity(
                "Java",  dataPublication, 1, 1, 1,1);
        services.insert(book);
        assertThat(book.getTitle()).isEqualTo("Java");
        assertThat(book.getData_publication()).isEqualTo(dataPublication);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);
        assertThat(book.getEdition()).isEqualTo(1);
    }
    @Test
    void update() throws BookNotFound, RegisterBookNotFound {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        LocalDate dataPublication2 = LocalDate.parse("2020-02-20");

        BookEntity book = new BookEntity(
                "Java",  dataPublication, 1, 1, 1,1);
        BookEntity book1 = new BookEntity(
                "Html",dataPublication2, 2, 1, 1,1);
        services.insert(book);

        services.update(1,book1);
        List<BookEntity> listBook = services.getAllBooks();

        assertThat(listBook.get(0).getTitle()).isEqualTo("Html");
        assertThat(listBook.get(0).getData_publication()).isEqualTo(dataPublication2);
        assertThat(listBook.get(0).getFkAuthor()).isEqualTo(1);
        assertThat(listBook.get(0).getFkLibrary()).isEqualTo(1);
        assertThat(listBook.get(0).getEdition()).isEqualTo(2);
    }

    @Test
    void getById() throws BookNotFound {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");


        BookEntity book = new BookEntity(
                "Java",dataPublication, 1, 1, 1,1);

        services.insert(book);
        services.getById(1);
        assertThat(book.getTitle()).isEqualTo("Java");
        assertThat(book.getData_publication()).isEqualTo(dataPublication);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);
        assertThat(book.getEdition()).isEqualTo(1);
    }

    @Test
    void getAllBooks() throws RegisterBookNotFound {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        LocalDate dataPublication2 = LocalDate.parse("2020-02-20");

        BookEntity book = new BookEntity(
                "Java",dataPublication, 1, 1, 1,1);
        BookEntity book1 = new BookEntity(
                "Html",dataPublication2, 2, 1, 1,1);
        services.insert(book);
        services.insert(book1);
        List<BookEntity> list = services.getAllBooks();
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getTitle()).isEqualTo(book.getTitle());
        assertThat(list.get(0).getData_publication()).isEqualTo(dataPublication);
        assertThat(list.get(0).getFkAuthor()).isEqualTo(1);
        assertThat(list.get(0).getFkLibrary()).isEqualTo(1);
        assertThat(list.get(0).getEdition()).isEqualTo(1);
    }
    @Test
    void delete() throws RegisterBookNotFound, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        LocalDate dataPublication2 = LocalDate.parse("2020-02-20");

        BookEntity book = new BookEntity(
                "Java",dataPublication, 1, 1, 1,1);
        BookEntity book1 = new BookEntity(
                "Html",dataPublication2, 2, 1, 1,1);
        services.insert(book);
        services.insert(book1);

        List<BookEntity> list = services.getAllBooks();
        assertThat(list.size()).isEqualTo(2);

        services.delete(2);
        List<BookEntity> list2 = services.getAllBooks();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(list.get(0).getTitle()).isEqualTo(book.getTitle());
        assertThat(list.get(0).getData_publication()).isEqualTo(dataPublication);
        assertThat(list.get(0).getFkAuthor()).isEqualTo(1);
        assertThat(list.get(0).getFkLibrary()).isEqualTo(1);
        assertThat(list.get(0).getEdition()).isEqualTo(1);
    }
    @Test
    void exceptionBookNotFound(){
        Throwable exception = catchThrowable(() -> {
            services.getById(1);
        });

        assertThat(exception)
                .isInstanceOf(BookNotFound.class)
                .hasMessageContaining("O Livro com o id 1 não  foi encontrado.");
    }
    @Test
    void exceptionRegisterBookNotFound(){
        Throwable exception = catchThrowable(() -> {
            services.getAllBooks();
        });

        assertThat(exception)
                .isInstanceOf(RegisterBookNotFound.class)
                .hasMessageContaining("Nenhum Livro foi cadastrado.");
    }
    @Test
    void exceptionUpdate(){
        LocalDate dataPublication = LocalDate.parse("1960-12-12");
        Integer id = 12 ;
        BookEntity book = new BookEntity(
                null,dataPublication,1,1,1,1);

        Throwable exception = catchThrowable(() -> {
            services.update(id,book);
        });

        assertThat(exception)
                .isInstanceOf(BookNotFound.class)
                .hasMessageContaining("O Livro com o id 12 não  foi encontrado.");
    }
    @Test
    void exceptionDelete(){

        Integer id = 12 ;
        Throwable exception = catchThrowable(() -> {
            services.delete(id);
        });

        assertThat(exception)
                .isInstanceOf(BookNotFound.class)
                .hasMessageContaining("O Livro com o id 12 não  foi encontrado.");
    }
}
