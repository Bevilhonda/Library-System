package com.teste.implementabiblioteca;

import java.time.Instant;

public class Livro {

    private final String titulo_livro;
    private final Author autor;
    private final Instant data_publication;
    private final int edicao;
    private final int id_livro;
    private final int id_biblioteca;

    public Livro(String titulo, Author autor, Instant data_publication, int edicao, int id_biblioteca, int id_livro) {
        this.titulo_livro = titulo;
        this.autor = autor;
        this.data_publication = data_publication;
        this.edicao = edicao;
        this.id_biblioteca = id_biblioteca;
        this.id_livro = id_livro;
    }

    public void Print_Livro() {
        System.out.println(titulo_livro);
        System.out.println(autor.getNome() + " " + autor.getSobrenome());
        System.out.println(data_publication);
        System.out.println(edicao);
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public Author getAutor() {
        return autor;
    }

    public Instant getData_publication() {
        return data_publication;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public int getId_livro() {
        return id_livro;
    }
}
