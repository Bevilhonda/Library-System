package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestRepositoryLibrary {
    @Autowired
    RepositoryLibrary repository;

    @Test
    void save() {
        repository.insert("Biblioteca Maringá", 1);

        LibraryEntity library = repository.getLibraryById(1);

        assertThat(library.getName()).isEqualTo("Biblioteca Maringá");
        assertThat(library.getFkAddress()).isEqualTo(1);
    }

    @Test
    void update() {

        repository.insert("Biblioteca Maringá", 1);

        /*
        LibraryEntity library1 = repository.getLibraryById(1);

        assertThat(library1.getName()).isEqualTo("Biblioteca Maringá");
        assertThat(library1.getFkAddress()).isEqualTo(1);

         */

        repository.update("Livraria Brasil", 1, 1);

        LibraryEntity library = repository.getLibraryById(1);

        assertThat(library.getName()).isEqualTo("Livraria Brasil");
        assertThat(library.getFkAddress()).isEqualTo(1);
    }

    @Test
    void getById() {
        repository.insert("Biblioteca Maringá", 1);
        repository.insert("Biblioteca Londrina", 2);

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getIdLibrary()).isEqualTo(1);
        assertThat(listLibrary.get(0).getName()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getFkAddress()).isEqualTo(1);

        assertThat(listLibrary.get(1).getIdLibrary()).isEqualTo(2);
        assertThat(listLibrary.get(1).getName()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(1).getFkAddress()).isEqualTo(2);
    }

    @Test
    void allLibrarys() {
        repository.insert("Biblioteca Maringá", 1);
        repository.insert("Biblioteca Londrina", 2);
        repository.insert("Biblioteca Curitiba", 3);

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(3);

        assertThat(listLibrary.get(0).getName()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getFkAddress()).isEqualTo(1);
        assertThat(listLibrary.get(1).getName()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(1).getFkAddress()).isEqualTo(2);
        assertThat(listLibrary.get(2).getName()).isEqualTo("Biblioteca Curitiba");
        assertThat(listLibrary.get(2).getFkAddress()).isEqualTo(3);
    }

    @Test
    void getByName() {
        repository.insert("Biblioteca Maringá", 1);
        repository.insert("Biblioteca Maringá", 2);

        List<LibraryEntity> listLibrary = repository.getLibraryByName("Biblioteca Maringá");
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getIdLibrary()).isEqualTo(1);
        assertThat(listLibrary.get(0).getName()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getFkAddress()).isEqualTo(1);

        assertThat(listLibrary.get(1).getIdLibrary()).isEqualTo(2);
        assertThat(listLibrary.get(1).getName()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(1).getFkAddress()).isEqualTo(2);
    }

    @Test
    void delete() {
        repository.insert("Biblioteca Maringá", 1);
        repository.insert("Biblioteca Londrina", 2);
        repository.insert("Biblioteca Curitiba", 3);

        repository.deleteLibrary(1);

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getIdLibrary()).isEqualTo(2);
        assertThat(listLibrary.get(0).getName()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(0).getFkAddress()).isEqualTo(2);

        assertThat(listLibrary.get(1).getIdLibrary()).isEqualTo(3);
        assertThat(listLibrary.get(1).getName()).isEqualTo("Biblioteca Curitiba");
        assertThat(listLibrary.get(1).getFkAddress()).isEqualTo(3);
    }

}
