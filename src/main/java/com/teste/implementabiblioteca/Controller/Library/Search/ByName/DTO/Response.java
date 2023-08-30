package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

public class Response {
    Integer id_biblioteca;
    String nome;
    Integer fk_endereco;

    public Response(Integer id_biblioteca, String nome, Integer fk_endereco) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.fk_endereco = fk_endereco;
    }
    public static Response from(LibraryEntity library){
        return new Response(library.getIdLibrary(),library.getName(),
                library.getFkAddress());
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
