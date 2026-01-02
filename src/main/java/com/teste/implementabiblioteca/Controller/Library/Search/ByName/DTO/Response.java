package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import java.util.List;

public class Response {
    public static List<Library> from(List<LibraryEntity> listLibrary) {

        return listLibrary
                .stream()
                .map(library -> new Library(
                        library.getId_biblioteca(),
                        library.getNome(),
                        library.getRua(),
                        library.getNumero(),
                        library.getBairro(), library.getCidade(),
                        library.getEstado())).toList();

    }
}
