package com.teste.implementabiblioteca.Repository.Author;

import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestById {
    @Autowired
    RepositoryAuthor repository;
    void getById(){
        LocalDate dateBirth = LocalDate.parse("2003-09-25");
        Integer saveAuthor =
                repository.save("Ricardo", "Batista", dateBirth);
    }
}
