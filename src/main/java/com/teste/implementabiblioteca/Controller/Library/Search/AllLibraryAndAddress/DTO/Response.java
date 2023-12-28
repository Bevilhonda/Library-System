package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

import java.util.List;

public record Response(List<LibraryAddressDTO> listAddress) {
    public static Response from(List<LibraryAddressDTO> librarysList) {
        return new Response(librarysList);
    }
}

