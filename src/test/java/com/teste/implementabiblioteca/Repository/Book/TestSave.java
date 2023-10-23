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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestSave {
    @Autowired
    private RepositoryBook repositoryBook;
    @Test
    void save(){
        LocalDate dataPublication = LocalDate.parse("2018-10-15");

        Integer savebook = repositoryBook.insert
                (
                        "Java",
                        dataPublication,
                        1,
                        1,
                        1
                );
        assertEquals(savebook,1);
        assertNotNull(savebook);
        BookEntity book = repositoryBook.getBook(1);
        assertThat(book.getIdBook()).isEqualTo(1);

    }
}
