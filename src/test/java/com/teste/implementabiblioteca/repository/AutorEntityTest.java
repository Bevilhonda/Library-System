package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AutorEntityTest {

    @Test
    public void Teste_Autor_Entity(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        AuthorEntity novo = new AuthorEntity(1,"Pedro","Batista",data_nascimento_autor);

        assertEquals(1,novo.getIdAuthor());
        assertEquals("Pedro",novo.getName());
        assertEquals("Batista",novo.getLastname());
        assertEquals(data_nascimento_autor,novo.getDateOfBirth());
    }

}