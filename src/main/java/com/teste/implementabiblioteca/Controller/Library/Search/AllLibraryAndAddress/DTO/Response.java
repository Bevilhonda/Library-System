package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

import java.util.List;

public record Response(List<DataLibrarys> listAddress) {
    public static Response from(List<DataLibrarys> librarysList) {
        return new Response(librarysList);
    }
}
