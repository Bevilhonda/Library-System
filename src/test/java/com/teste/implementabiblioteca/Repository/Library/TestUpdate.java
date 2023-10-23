package com.teste.implementabiblioteca.Repository.Library;

import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestUpdate {
    @Autowired
    private RepositoryLibrary repository;
    @Test
    void update(){

    }
}
