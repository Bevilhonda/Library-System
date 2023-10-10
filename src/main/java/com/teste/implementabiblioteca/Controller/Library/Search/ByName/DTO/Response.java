package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import java.util.List;

public class Response {
    private final List<Library> list;

    public Response(List<Library> list) {
        this.list = list;
    }

    public static List<Library> from(List<LibraryEntity> listLibrary){
        return listLibrary.stream().map(library -> new Library(library.getIdLibrary(),
                library.getName(),library.getFkAddress())).toList();

    }
}
