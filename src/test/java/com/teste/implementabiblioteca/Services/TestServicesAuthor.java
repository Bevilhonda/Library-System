package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.*;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DataJpaTest
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestServicesAuthor {
    @Autowired
    ServicesAuthor services;

    @Test
    void insert() throws ErrorSavingAuthor, AuthorNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth);

        services.insert(author);
        AuthorEntity authorActual = services.getById(1);
        assertThat(authorActual.getName()).isEqualTo(author.getName());
        assertThat(authorActual.getLastname()).isEqualTo(author.getLastname());
        assertThat(authorActual.getDateBirth()).isEqualTo(author.getDateBirth());
    }

    @Test
    void update() throws ErrorSavingAuthor, AuthorNotFound, RegisterNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth);
        AuthorEntity authorActual = new AuthorEntity(
                null, "Pedro", "Santos", dateBirth);

        services.insert(author);

        services.updateAuthor(1, authorActual);

        List<AuthorEntity> list = services.getAllAuthors();
        assertThat(list.size()).isEqualTo(1);

        assertThat(list.get(0).getName()).isEqualTo(authorActual.getName());
        assertThat(list.get(0).getLastname()).isEqualTo(authorActual.getLastname());
        assertThat(list.get(0).getDateBirth()).isEqualTo(authorActual.getDateBirth());
    }

    @Test
    void getById() throws ErrorSavingAuthor, AuthorNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth);

        services.insert(author);

        AuthorEntity authorActual = services.getById(1);
        assertThat(authorActual.getName()).isEqualTo(author.getName());
        assertThat(authorActual.getLastname()).isEqualTo(author.getLastname());
        assertThat(authorActual.getDateBirth()).isEqualTo(author.getDateBirth());
    }

    @Test
    void getAll() throws ErrorSavingAuthor, RegisterNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth);
        AuthorEntity author2 = new AuthorEntity(
                null, "Pedro", "Santos", dateBirth);
        services.insert(author);
        services.insert(author2);

        List<AuthorEntity> list = services.getAllAuthors();
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getName()).isEqualTo(author.getName());
        assertThat(list.get(0).getLastname()).isEqualTo(author.getLastname());
        assertThat(list.get(0).getDateBirth()).isEqualTo(author.getDateBirth());
    }

    @Test
    void getByDate() throws ErrorSavingAuthor, DateBirthNotFound {
        LocalDate dateBirth1 = LocalDate.parse("1989-06-15");
        LocalDate dateBirth2 = LocalDate.parse("1999-12-25");

        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth1);
        AuthorEntity author2 = new AuthorEntity(
                null, "Pedro", "Santos", dateBirth2);

        services.insert(author);
        services.insert(author2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateBirthF1 = dateBirth1.format(formatter);
        String dateBirthF2 = dateBirth2.format(formatter);

        List<AuthorEntity> listAuthor = services.getByDateBirth(dateBirthF1, dateBirthF2);
        assertThat(listAuthor.get(0).getDateBirth()).isEqualTo(dateBirth1);
    }

    @Test
    void getByLastName() throws ErrorSavingAuthor, LastNameNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth);

        services.insert(author);

        List<AuthorEntity> list = services.getByLastName("Batista");

        assertThat(list.get(0).getLastname()).isEqualTo("Batista");
        assertThat(list.get(0).getName()).isEqualTo(author.getName());
        assertThat(list.get(0).getDateBirth()).isEqualTo(author.getDateBirth());
    }

    @Test
    void delete() throws ErrorSavingAuthor, RegisterNotFound, AuthorNotFound {
        LocalDate dateBirth1 = LocalDate.parse("1989-06-15");
        LocalDate dateBirth2 = LocalDate.parse("1999-12-25");

        AuthorEntity author = new AuthorEntity(
                null, "Jorge", "Batista", dateBirth1);
        AuthorEntity author2 = new AuthorEntity(
                null, "Pedro", "Santos", dateBirth2);

        services.insert(author);
        services.insert(author2);

        List<AuthorEntity> list = services.getAllAuthors();
        assertThat(list.size()).isEqualTo(2);

        services.delete(1);
        AuthorEntity authorActual = services.getById(2);

        List<AuthorEntity> list2 = services.getAllAuthors();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(list2.get(0).getName()).isEqualTo(authorActual.getName());
        assertThat(list2.get(0).getLastname()).isEqualTo(authorActual.getLastname());
        assertThat(list2.get(0).getDateBirth()).isEqualTo(authorActual.getDateBirth());
    }

    @Test
    void exceptionAuthorNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getById(1);
        });

        assertThat(exception)
                .isInstanceOf(AuthorNotFound.class)
                .hasMessageContaining("O Autor com o id 1 não  foi encontrado.");
    }

    @Test
    void exceptionLastNameNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getByLastName("Santos");
        });

        assertThat(exception)
                .isInstanceOf(LastNameNotFound.class)
                .hasMessageContaining("Não foi encontrado nenhum autor com o sobrenome Santos");
    }

    @Test
    void exceptionRegisterNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getAllAuthors();

        });

        assertThat(exception)
                .isInstanceOf(RegisterNotFound.class)
                .hasMessageContaining("Nenhum autor foi cadastrado.");
    }

    @Test
    void exceptionDateBirthNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getByDateBirth("1990-01-01", "2000-01-01");

        });

        assertThat(exception)
                .isInstanceOf(DateBirthNotFound.class)
                .hasMessageContaining(
                        "Não foi encontrado autor nascido entre: 1990-01-01 á: 2000-01-01");
    }

    // E o Insert author = ErrorSavingAuthor  ? , try catch no controler ?
}
