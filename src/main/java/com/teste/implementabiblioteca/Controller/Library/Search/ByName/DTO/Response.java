package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import java.util.List;

public class Response {
    private final List<com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response> list;

    public Response(List<com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response> list) {
        this.list = list;
    }

    public static List<com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response> from(List<LibraryEntity> listLibrary){
        return listLibrary.stream().map(library -> new com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response(library.getIdLibrary(),
                library.getName(),library.getFkAddress())).toList();

    }
}
