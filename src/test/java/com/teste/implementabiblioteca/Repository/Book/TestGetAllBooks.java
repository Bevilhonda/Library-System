package com.teste.implementabiblioteca.Repository.Book;

import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestGetAllBooks {
    @Autowired
    private RepositoryBook repositoryBook;
    @Test
    void allBooks(){
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        Integer savebook = repositoryBook.insert
                (
                        "Java",
                        dataPublication,
                        1,
                        1,
                        1
                );

        Integer savebook1 = repositoryBook.insert
                (
                        "Java",
                        dataPublication,
                        1,
                        1,
                        1
                );
        List<BookEntity> listBook = repositoryBook.getAllBooks();
        assertThat(listBook).isNotNull();
        assertThat(listBook.size()).isEqualTo(2);

    }
}
