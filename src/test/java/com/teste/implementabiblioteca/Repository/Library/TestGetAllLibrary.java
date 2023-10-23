package com.teste.implementabiblioteca.Repository.Library;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestGetAllLibrary {
    @Autowired
    private RepositoryLibrary repository;
    @Test
    void allLibrarys(){
        Integer saveLibrary = repository.insert("Biblioteca Maringá", 1);
        Integer saveLibrary1 = repository.insert("Biblioteca Londrina", 2);
        Integer saveLibrary2 = repository.insert("Biblioteca Curitiba", 3);

        List<LibraryEntity> listLibrary = repository.getAllLibrary();
        assertThat(listLibrary).isNotNull();
        assertThat(listLibrary.get(0).getName()).isEqualTo("Biblioteca Maringá");
        assertThat(listLibrary.get(1).getName()).isEqualTo("Biblioteca Londrina");
        assertThat(listLibrary.get(2).getName()).isEqualTo("Biblioteca Curitiba");

    }
}
