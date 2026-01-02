package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

public record FullAddress(String street, Integer number, String boroughs) {

    public static FullAddress createFullAddress(String street, Integer number, String boroughs) {
        return new FullAddress(street, number, boroughs);
    }

}
