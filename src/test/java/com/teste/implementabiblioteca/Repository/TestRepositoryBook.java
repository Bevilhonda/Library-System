package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Book.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestRepositoryBook {
    @Autowired
    RepositoryBook repository;
    @Test
    void save() {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        repository.insert("Java", dataPublication, 1, 1, 1);

        BookEntity book = repository.getBook(1);

        assertThat(book.getTitle()).isEqualTo("Java");
        assertThat(book.getData_publication()).isEqualTo(dataPublication);
        assertThat(book.getEdition()).isEqualTo(1);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);
    }
    @Test
    void update() {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        LocalDate dataPublication2 = LocalDate.parse("2019-01-20");

        repository.insert("Java", dataPublication, 1, 1, 1);

        repository.update("Html", dataPublication2, 2, 1);

        BookEntity book = repository.getBook(1);

        assertThat(book.getTitle()).isEqualTo("Html");
        assertThat(book.getData_publication()).isEqualTo(dataPublication2);
        assertThat(book.getEdition()).isEqualTo(2);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);
    }
    @Test
    void getBooksById(){
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        repository.insert("Java",dataPublication,1,1,1);

        BookEntity book = repository.getBook(1);

        assertThat(book.getTitle()).isEqualTo("Java");
        assertThat(book.getData_publication()).isEqualTo(dataPublication);
        assertThat(book.getEdition()).isEqualTo(1);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);
    }
    @Test
    void allBooks(){
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        LocalDate dataPublication2 = LocalDate.parse("2020-02-20");

        repository.insert("Java",dataPublication,1,1,1);

        repository.insert("Html",dataPublication2,2,1,1);

        List<BookEntity> listBook = repository.getAllBooks();
        assertThat(listBook.size()).isEqualTo(2);

        BookEntity book = repository.getBook(1);

        assertThat(book.getTitle()).isEqualTo("Java");
        assertThat(book.getData_publication()).isEqualTo(dataPublication);
        assertThat(book.getEdition()).isEqualTo(1);
        assertThat(book.getFkAuthor()).isEqualTo(1);
        assertThat(book.getFkLibrary()).isEqualTo(1);

        BookEntity book2 = repository.getBook(2);

        assertThat(book2.getTitle()).isEqualTo("Html");
        assertThat(book2.getData_publication()).isEqualTo(dataPublication2);
        assertThat(book2.getEdition()).isEqualTo(2);
        assertThat(book2.getFkAuthor()).isEqualTo(1);
        assertThat(book2.getFkLibrary()).isEqualTo(1);
    }
    @Test
    void delete() {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        repository.insert("Java", dataPublication, 1, 1, 1);

        List<BookEntity> listBook = repository.getAllBooks();

        assertThat(listBook.size()).isEqualTo(1);

        repository.delete(1);

        List<BookEntity> listBook2 = repository.getAllBooks();
        assertThat(listBook2.size()).isEqualTo(0);
    }
}
