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
class TestSelectAuthor {
    @Autowired
    RepositoryAuthor repository;

    @Test
    @Transactional
    public void select() {
        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        LocalDate data_nascimento_autor1 = LocalDate.parse("2023-10-15");

        Integer author = repository.save
                (
                        "Pedro",
                        "Batista",
                        data_nascimento_autor
                );

        //AuthorEntity author1 = repository.getAuthor(1);
        //assertThat(author1.getIdAuthor()).isEqualTo(1);

        assertThat(author).isEqualTo(1);

        List<AuthorEntity> autorList = repository.getAllAuthors(); //  função que retorna todos autores

        assertThat(autorList).isNotNull();// a autorList não é nula ? = não é nula
        assertThat(autorList.size()).isEqualTo(1);// a autorList tem o tamanho igual á 1 ? = sim

        AuthorEntity authorIndex0 = autorList.get(0); // pega o autor na posição 0 da lista

        assertThat(authorIndex0.getIdAuthor()).isEqualTo(2);
        assertThat(authorIndex0.getName()).isNotEqualTo("Jorge");
        assertThat(authorIndex0.getLastname()).isEqualTo("Batista");

        assertThat(authorIndex0.getDateBirth()).isNotEqualTo(data_nascimento_autor1);
        /* Está verificando se a data de nascimento do autor que foi salvo no banco de dados
        não é igual à data de nascimento criada como segunda opção */

    }
}