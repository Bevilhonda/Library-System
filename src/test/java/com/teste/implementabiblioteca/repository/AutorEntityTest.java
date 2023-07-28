package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AutorEntityTest {

    @Test
    public void Teste_Autor_Entity(){
        LocalDate data_nascimento_autor = LocalDate.from(LocalDate.parse("2018-10-15"));
        AuthorEntity novo = new AuthorEntity(1,"Pedro","Batista",data_nascimento_autor);

        assertEquals(1,novo.getIdAuthor());
        assertEquals("Pedro",novo.getName());
        assertEquals("Batista",novo.getLastname());
        assertEquals(data_nascimento_autor,novo.getDateBirth());
    }

}