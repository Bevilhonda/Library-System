package com.teste.implementabiblioteca.Repository.Library;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestSave {
    @Autowired
    private RepositoryLibrary repository;
    @Test
    void save(){
        Integer saveLibrary = repository.insert("Biblioteca Maringá", 1);

        LibraryEntity library = repository.getLibraryById(1);

        assertThat(library.getIdLibrary()).isEqualTo(1);

    }
}
