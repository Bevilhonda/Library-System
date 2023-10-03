package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

public class FullAddress {
    private final String street;
    private final Integer number;
    private final String neighborhood;

    public FullAddress(String street, Integer number, String neighborhood) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
    }
    public static FullAddress createFullAddress(String street, Integer number, String neighborhood) {
        return new FullAddress(street, number, neighborhood);
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}
