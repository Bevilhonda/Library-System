package com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

public record Library(Integer id_biblioteca, String nome, String rua, Integer numero,
                      String cidade, String bairro, String estado) {

    public static Library from(LibraryEntity library) {

        return new Library(
                library.getId_biblioteca(),
                library.getNome(),
                library.getRua(),
                library.getNumero(),
                library.getBairro(),
                library.getCidade(),
                library.getEstado());
    }
}
