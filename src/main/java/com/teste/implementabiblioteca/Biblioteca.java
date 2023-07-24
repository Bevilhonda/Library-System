package com.teste.implementabiblioteca;

import java.util.List;

public class Biblioteca {

    private final String nome_da_biblioteca;
    private final List<Livro> lista_de_livro;
    private final Endereco endereco;
    private final int id_biblioteca;

    public Biblioteca(String nome, List<Livro> lista_de_livro, Endereco endereco, int id_biblioteca) {
        this.nome_da_biblioteca = nome;
        this.lista_de_livro = lista_de_livro;
        this.endereco = endereco;
        this.id_biblioteca = id_biblioteca;
    }

    public String getNome_da_biblioteca() {
        return nome_da_biblioteca;
    }

    public List<Livro> getLista_de_livro() {
        return lista_de_livro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }
}