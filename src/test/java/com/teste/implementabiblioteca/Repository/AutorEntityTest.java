package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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