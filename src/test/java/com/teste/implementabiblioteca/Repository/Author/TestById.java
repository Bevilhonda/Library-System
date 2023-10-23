package com.teste.implementabiblioteca.Repository.Author;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestById {
    @Autowired
    RepositoryAuthor repository;
    @Test
    void getById(){
        LocalDate dateBirth = LocalDate.parse("2003-09-25");

        Integer saveAuthor =
                repository.save("Ricardo", "Batista", dateBirth);

        AuthorEntity author = repository.getAuthor(1);

        assertThat(author.getIdAuthor()).isEqualTo(1);
        assertThat(author.getName()).isEqualTo("Ricardo");
        assertThat(author.getLastname()).isEqualTo("Batista");
        assertThat(author.getDateBirth()).isEqualTo(dateBirth);
    }
}
