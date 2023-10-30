package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestRepositoryAuthor {
    @Autowired
    RepositoryAuthor repository;

    @Test
    public void save() {

        LocalDate dateBirth = LocalDate.parse("2018-10-15");

        repository.save("Lucas", "Batista", dateBirth);

        List<AuthorEntity> autorlist = repository.getAllAuthors();

        assertThat(autorlist.size()).isEqualTo(1);

        AuthorEntity atual = autorlist.get(0);

        assertThat(atual.getName()).isEqualTo("Lucas");
        assertThat(atual.getLastname()).isEqualTo("Batista");
        assertThat(atual.getDateBirth()).isEqualTo(dateBirth);
    }

    @Test
    public void update() {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", dateBirth);

        repository.updateAuthor("Jorge", "Santos", dateBirth, 1);

        List<AuthorEntity> lista_de_autores1 = repository.getAllAuthors();
        AuthorEntity author = lista_de_autores1.get(0);

        Assertions.assertThat(author.getName()).isEqualTo("Jorge");
        Assertions.assertThat(author.getLastname()).isEqualTo("Santos");
        Assertions.assertThat(author.getDateBirth()).isEqualTo(dateBirth);
    }

    @Test
    void getById() {
        LocalDate dateBirth = LocalDate.parse("2003-09-25");

        repository.save("Ricardo", "Batista", dateBirth);

        AuthorEntity author = repository.getAuthor(1);

        assertThat(author.getIdAuthor()).isEqualTo(1);
        assertThat(author.getName()).isEqualTo("Ricardo");
        assertThat(author.getLastname()).isEqualTo("Batista");
        assertThat(author.getDateBirth()).isEqualTo(dateBirth);
    }

    @Test
    void getByLastName() {

        LocalDate dateBirth = LocalDate.parse("2003-09-25");

        repository.save("Ricardo", "Batista", dateBirth);

        List<AuthorEntity> author = repository.getByLastName("Batista");

        AuthorEntity currentAuthor = author.get(0);

        assertThat(currentAuthor.getLastname()).isEqualTo("Batista");

    }

    @Test
    void selectByDateBirth() {

        LocalDate dateBirth1 = LocalDate.parse("1989-06-15");
        LocalDate dateBirth2 = LocalDate.parse("1999-12-25");
        LocalDate dateBirth3 = LocalDate.parse("2000-02-20");

        repository.save("Ricardo", "Batista", dateBirth1);
        repository.save("Pedro", "Batista", dateBirth2);

        List<AuthorEntity> listAuthor = repository.getByDate(dateBirth1, dateBirth2);
        assertThat(listAuthor.get(0).getDateBirth()).isEqualTo(dateBirth1);
    }

    @Test
    void getAllAuthors() {

        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", data_nascimento_autor);
        repository.save("Jorge", "Santos", data_nascimento_autor);
        repository.save("Lucas", "Silva", data_nascimento_autor);

        List<AuthorEntity> listAuthors = repository.getAllAuthors();

        Assertions.assertThat(listAuthors.size()).isEqualTo(3);
        Assertions.assertThat(listAuthors.get(0).getLastname()).isEqualTo("Batista");
    }

    @Test
    public void select() {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", dateBirth);

        List<AuthorEntity> autorList = repository.getAllAuthors();

        assertThat(autorList.size()).isEqualTo(1);

        AuthorEntity authorIndex0 = autorList.get(0);

        assertThat(authorIndex0.getName()).isNotEqualTo("Jorge");
        assertThat(authorIndex0.getLastname()).isEqualTo("Batista");
        assertThat(authorIndex0.getDateBirth()).isEqualTo(dateBirth);

    }

    @Test
    public void delete() {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");

        repository.save("Pedro", "Batista", dateBirth);
        repository.save("Jorge", "Santos", dateBirth);

        repository.deleteAuthor(1);

        List<AuthorEntity> lista_de_autores = repository.getAllAuthors();
        Assertions.assertThat(lista_de_autores.size()).isEqualTo(1);

        AuthorEntity author2 = lista_de_autores.get(0);

        Assertions.assertThat(author2.getDateBirth()).isEqualTo(dateBirth);
        Assertions.assertThat(author2.getIdAuthor()).isEqualTo(2);
        Assertions.assertThat(author2.getName()).isEqualTo("Jorge");
        Assertions.assertThat(author2.getLastname()).isEqualTo("Santos");
    }

}
