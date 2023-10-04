package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

public class FullAddress {
    private final String street;
    private final Integer number;
    private final String boroughs;

    public FullAddress(String street, Integer number, String boroughs) {
        this.street = street;
        this.number = number;
        this.boroughs = boroughs;
    }
    public static FullAddress createFullAddress(String street, Integer number, String boroughs) {
        return new FullAddress(street, number, boroughs);
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getBoroughs() {
        return boroughs;
    }
}
