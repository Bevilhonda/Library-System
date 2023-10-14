package com.teste.implementabiblioteca.Model.Author;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AutorEntityTest {

    @Test
  void AuthorEntityTest() {
        LocalDate data_nascimento_autor = LocalDate.parse("2018-10-15");

        LocalDate data_nascimento_autor1 = LocalDate.parse("2018-10-14");

        AuthorEntity novo =
                new AuthorEntity(
                        1,
                        "Pedro",
                        "Batista",
                        data_nascimento_autor
                );

        assertEquals(1, novo.getIdAuthor());
        assertEquals("Pedro", novo.getName());
        assertEquals("Batista", novo.getLastname());
        assertEquals(data_nascimento_autor, novo.getDateBirth());
    }
}