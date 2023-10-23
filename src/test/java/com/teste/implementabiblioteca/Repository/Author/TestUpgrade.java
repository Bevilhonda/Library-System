package com.teste.implementabiblioteca.Repository.Author;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestUpgrade {
    @Autowired
    RepositoryAuthor repository;

    @Test
    @Transactional
    public void update() {
        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        Integer saveAuthor = repository.save
                ("Pedro",
                        "Batista",
                        data_nascimento_autor
                );

        List<AuthorEntity> listAuthors = repository.getAllAuthors();

        assertThat(listAuthors).isNotNull();
        assertThat(listAuthors.size()).isEqualTo(1);
        AuthorEntity atual = listAuthors.get(0);

        assertThat(atual.getIdAuthor()).isEqualTo(1);
        assertThat(atual.getName()).isEqualTo("Pedro");
        assertThat(atual.getLastname()).isEqualTo("Batista");

        repository.updateAuthor("Jorge", "Santos", data_nascimento_autor, 1);

        List<AuthorEntity> lista_de_autores1 = repository.getAllAuthors();
        AuthorEntity atual1 = lista_de_autores1.get(0);

        assertThat(atual1.getIdAuthor()).isEqualTo(1);
        assertThat(atual1.getName()).isEqualTo("Jorge");
        assertThat(atual1.getLastname()).isEqualTo("Batista");

        System.out.println(atual1.getName());
    }
}
