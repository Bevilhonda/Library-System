package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

public record FullAddress(String street, Integer number, String neighborhood) {

    public static FullAddress createFullAddress(String street, Integer number, String neighborhood) {
        return new FullAddress(street, number, neighborhood);
    }

}
