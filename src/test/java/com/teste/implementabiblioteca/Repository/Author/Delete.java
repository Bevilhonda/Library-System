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
public class Delete {
    @Autowired
    RepositoryAuthor repository;

    @Test
    @Transactional
    public void deleteFull() {
        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", data_nascimento_autor);
        repository.save("Jorge", "Batista", data_nascimento_autor);
        repository.save("Lucas", "Batista", data_nascimento_autor);

        repository.deleteAuthor(1);

        List<AuthorEntity> lista_de_autores = repository.getAllAuthors();
        assertThat(lista_de_autores.size()).isEqualTo(2);

        AuthorEntity author1 = lista_de_autores.get(0);

        assertThat(author1.getDateBirth()).isEqualTo(data_nascimento_autor);
        assertThat(author1.getIdAuthor()).isEqualTo(2);
        assertThat(author1.getName()).isEqualTo("Jorge");
        assertThat(author1.getLastname()).isEqualTo("Batista");

        AuthorEntity author3 = lista_de_autores.get(1);

        assertThat(author3.getDateBirth()).isEqualTo(data_nascimento_autor);
        assertThat(author3.getIdAuthor()).isEqualTo(3);
        assertThat(author3.getName()).isEqualTo("Lucas");
        assertThat(author3.getLastname()).isEqualTo("Batista");
    }
}
