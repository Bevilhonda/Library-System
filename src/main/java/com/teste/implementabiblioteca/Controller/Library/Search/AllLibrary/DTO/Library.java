package com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

public record Library(Integer idLibrary, String name, Integer address) {

    public static Library from(LibraryEntity library){
        return new Library(library.getIdLibrary(),library.getName(),library.getFkAddress());
    }
}
