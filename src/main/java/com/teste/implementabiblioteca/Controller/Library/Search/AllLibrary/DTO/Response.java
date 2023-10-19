package com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary.DTO;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import java.util.List;

public record Response(List<Library> libraryList) {

    public static Response from(List<LibraryEntity> listLibrary) {
        List<Library> librarys = listLibrary.stream().
                map(library -> Library.from(library)).toList();

        return new Response(librarys);
    }
}
