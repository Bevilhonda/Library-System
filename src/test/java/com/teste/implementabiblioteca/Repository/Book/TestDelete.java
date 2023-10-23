package com.teste.implementabiblioteca.Repository.Book;


import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestDelete {

    @Autowired
    private RepositoryBook repositoryBook;

    @Test
    void delete(){
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

        assertNotNull(savebook);
        assertEquals(savebook,1);
        BookEntity book = repositoryBook.getBook(1);

        Integer deleteBook = repositoryBook.delete(1);

        List<BookEntity> listBook2 = repositoryBook.getAllBooks();
        AssertionsForClassTypes.assertThat(listBook2.size()).isEqualTo(1);




    }
}
