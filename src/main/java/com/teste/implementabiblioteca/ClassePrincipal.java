package com.teste.implementabiblioteca;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class ClassePrincipal {

    public static void main(String[] args) {

        Endereco endereco_da_biblioteca = new Endereco
                ("Rua Cinza numero ", 20, "Bairro Centro", "Maringá", "Paraná", 1);

        Instant data_nascimento = LocalDateTime.parse
                ("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);

        Author autor = new Author(
                "Jorge", "Lima", data_nascimento, 1);

        Instant data_publicacao = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);

        Livro livro = new Livro
                ("Programação em html", autor, data_publicacao, 1, 1, 32);

        List<Livro> livros = new ArrayList<>();
        livros.add(livro);

        Biblioteca maringa = new Biblioteca
                (" Biblioteca do Povo ", livros, endereco_da_biblioteca, 1);
    }
}
