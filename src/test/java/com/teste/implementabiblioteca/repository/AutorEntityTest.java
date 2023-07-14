package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AutorEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class AutorEntityTest {

    @Test
    public void Teste_Autor_Entity(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        AutorEntity novo = new AutorEntity(1,"Pedro","Batista",data_nascimento_autor);

        assertEquals(1,novo.getId_autor());
        assertEquals("Pedro",novo.getNome());
        assertEquals("Batista",novo.getSobrenome());
        assertEquals(data_nascimento_autor,novo.getData_nascimento());
    }

}