package com.teste.implementabiblioteca.Controller.Address.Search.GetAddressByNameCIty.DTO;

public record FullAddress(String street, Integer number, String boroughs, String city, String state) {

    public static FullAddress createAddressByCity(String street, Integer number, String boroughs,
                                                  String city , String state){
        return new FullAddress(street,number,boroughs,city,state);
    }
}
