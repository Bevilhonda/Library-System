package com.teste.implementabiblioteca.Controller.Library.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataLibraryEntity {

    @JsonProperty("id_biblioteca")
    Integer id_biblioteca;
    @JsonProperty("nome")
    String nome;
    @JsonProperty("fk_endereco")
    Integer fk_endereco;

    public DataLibraryEntity(Integer id_biblioteca, String nome, Integer fk_endereco) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.fk_endereco = fk_endereco;
    }

    public Integer getId_biblioteca() {
        return id_biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public Integer getFk_endereco() {
        return fk_endereco;
    }
}
