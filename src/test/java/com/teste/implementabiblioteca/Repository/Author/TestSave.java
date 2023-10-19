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
public class TestSave {
    @Autowired
    RepositoryAuthor repository;
    @Test
    @Transactional
    public void save() {

        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        Integer author2 = repository.save
                (
                        "Lucas",
                        "Batista",
                        data_nascimento_autor
                );

        List<AuthorEntity> autorlist = repository.getAllAuthors();
        assertThat(autorlist).isNotNull();
        assertThat(autorlist.size()).isEqualTo(1);

        AuthorEntity atual = autorlist.get(0);

        assertThat(atual.getIdAuthor()).isEqualTo(4);
        assertThat(atual.getName()).isEqualTo("Lucas");
        assertThat(atual.getLastname()).isEqualTo("Batista");
    }

}
