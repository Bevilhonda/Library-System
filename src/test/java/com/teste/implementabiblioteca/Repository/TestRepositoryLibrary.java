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
    void insert() {
        repository.saveLibrary("Biblioteca Maringá","Madre Paula",13,
                "Centro","Maringá","Paraná");

        LibraryEntity library = repository.getLibraryById(1);

        assertThat(library.getId_biblioteca()).isEqualTo(1);
        assertThat(library.getNome()).isEqualTo("Biblioteca Maringá");
        assertThat(library.getRua()).isEqualTo("Madre Paula");
        assertThat(library.getNumero()).isEqualTo(13);
        assertThat(library.getBairro()).isEqualTo("Centro");
        assertThat(library.getCidade()).isEqualTo("Maringá");
        assertThat(library.getEstado()).isEqualTo("Paraná");

    }

    @Test
    void update() {

        repository.saveLibrary("Biblioteca Maringá","Madre Paula",13,
                "Centro","Maringá","Paraná");

        repository.update("Livraria Brasil","Madre",20,"Centro",
                "Maringá","Paraná",1);

        LibraryEntity library = repository.getLibraryById(1);

        assertThat(library.getNome()).isEqualTo("Livraria Brasil");
        assertThat(library.getId_biblioteca()).isEqualTo(1);
        assertThat(library.getRua()).isEqualTo("Madre");
        assertThat(library.getNumero()).isEqualTo(20);
        assertThat(library.getBairro()).isEqualTo("Centro");
        assertThat(library.getCidade()).isEqualTo("Maringá");
        assertThat(library.getEstado()).isEqualTo("Paraná");

    }

    @Test
    void getById() {
        repository.saveLibrary("Biblioteca Maringá","Madre Paula",13,
                "Centro","Maringá","Paraná");
        repository.saveLibrary("Biblioteca Londrina","Madre",20,
                "Centro","Londrina","Paraná");

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getId_biblioteca()).isEqualTo(1);
        assertThat(listLibrary.get(0).getNome()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getNumero()).isEqualTo(13);

        assertThat(listLibrary.get(1).getId_biblioteca()).isEqualTo(2);
        assertThat(listLibrary.get(1).getNome()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(1).getNumero()).isEqualTo(20);
    }

    @Test
    void allLibrarys() {
        repository.saveLibrary("Biblioteca Maringá","Madre Paula",13,
                "Centro","Maringá","Paraná");
        repository.saveLibrary("Biblioteca Londrina","Madre",20,
                "Centro","Londrina","Paraná");


        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getId_biblioteca()).isEqualTo(1);
        assertThat(listLibrary.get(0).getNome()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getNumero()).isEqualTo(13);

        assertThat(listLibrary.get(1).getId_biblioteca()).isEqualTo(2);
        assertThat(listLibrary.get(1).getNome()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(1).getNumero()).isEqualTo(20);



    }

    @Test
    void getByName() {
        repository.saveLibrary("Biblioteca Maringá","Madre Paula",13,
                "Centro","Maringá","Paraná");
        repository.saveLibrary("Biblioteca Londrina","Madre",20,
                "Centro","Londrina","Paraná");

        List<LibraryEntity> listLibrary = repository.getLibraryByName("Biblioteca Maringá");
        assertThat(listLibrary.size()).isEqualTo(1);

        assertThat(listLibrary.get(0).getId_biblioteca()).isEqualTo(1);
        assertThat(listLibrary.get(0).getNome()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getNumero()).isEqualTo(13);
    }

    @Test
    void delete() {
        repository.saveLibrary("Biblioteca Curitiba","Madre Paula",130,
                "Centro","Maringá","Paraná");
        repository.saveLibrary("Biblioteca Maringá","Madre",13,
                "Centro","Londrina","Paraná");
        repository.saveLibrary("Biblioteca Londrina","Madre",20,
                "Centro","Londrina","Paraná");

        repository.delete(1);

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary.size()).isEqualTo(2);

        assertThat(listLibrary.get(0).getId_biblioteca()).isEqualTo(2);
        assertThat(listLibrary.get(0).getNome()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(0).getNumero()).isEqualTo(13);

        assertThat(listLibrary.get(1).getId_biblioteca()).isEqualTo(3);
        assertThat(listLibrary.get(1).getNome()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(1).getNumero()).isEqualTo(20);

    }

}
