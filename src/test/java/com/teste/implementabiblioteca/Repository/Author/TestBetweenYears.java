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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestBetweenYears {
    @Autowired
    RepositoryAuthor repository;


    @Test
    void selectByDateBirth() {

        LocalDate dateBirth1 = LocalDate.parse("1989-06-15");
        LocalDate dateBirth2 = LocalDate.parse("1999-12-25");
        LocalDate dateBirth3 = LocalDate.parse("2001-01-01");
        LocalDate dateBirth4 = LocalDate.parse("2002-06-15");
        LocalDate dateBirth5 = LocalDate.parse("2003-09-25");

        Integer saveAuthor =
                repository.save("Ricardo", "Batista", dateBirth1);
        Integer saveAuthor1 =
                repository.save("Pedro", "Batista", dateBirth2);
        Integer saveAuthor2 =
                repository.save("Jorge", "Santos", dateBirth3);
        Integer saveAuthor3 =
                repository.save("Danilo", "Alves", dateBirth4);
        Integer saveAuthor4 =
                repository.save("Marta", "Brasil", dateBirth5);

        List<AuthorEntity> allAuthors = repository.getAllAuthors();

        assertThat(allAuthors).isNotNull();

        List<AuthorEntity> listAuthor = repository.getByDate(dateBirth1,dateBirth5);
        assertThat(listAuthor).isNotNull();
    }
}
