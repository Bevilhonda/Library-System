package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

public class Library {
    Integer id_biblioteca;
    String nome;
    String rua;
    Integer numero;
    String cidade;
    String bairro;
    String estado;

    public Library(Integer id_biblioteca, String nome, String rua, Integer numero,
                   String cidade, String bairro, String estado) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public static Library from(LibraryEntity library){

        return new Library(
                library.getId_biblioteca(),
                library.getNome(),
                library.getRua(),
                library.getNumero(),
                library.getBairro(),
                library.getCidade(),
                library.getEstado());
    }

    public Integer getId_biblioteca() {
        return id_biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }
}
