package com.teste.implementabiblioteca.Controller.Library.Search.ByName.DTO;

import com.teste.implementabiblioteca.Controller.Library.Search.ById.DTO.Response;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import java.util.List;

public class ListLibrary {
    public static List<Response> from(List<LibraryEntity> listLibrary){
        return listLibrary.stream().map(library -> new Response(library.getIdLibrary(),
                library.getName(),library.getFkAddress())).toList();

    }
}
