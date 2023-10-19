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
public class GetAll {
    @Autowired
    RepositoryAuthor repository;
    @Test
    void getAllAuthors(){

        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", data_nascimento_autor);
        repository.save("Jorge", "Batista", data_nascimento_autor);
        repository.save("Lucas", "Batista", data_nascimento_autor);

        List<AuthorEntity> listAuthors = repository.getAllAuthors();

        assertThat(listAuthors.size()).isEqualTo(3);
        assertThat(listAuthors).isNotNull();
    }
}
