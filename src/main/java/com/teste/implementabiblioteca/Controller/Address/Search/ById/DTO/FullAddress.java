package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

public class FullAddress {
    private final String FullNameAddress;

    public FullAddress(String fullNameAddress) {
        FullNameAddress = fullNameAddress;
    }

    public String getFullName() {
        return FullNameAddress;
    }
}
