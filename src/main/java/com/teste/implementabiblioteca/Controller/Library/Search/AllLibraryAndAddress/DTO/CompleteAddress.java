package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

public record CompleteAddress(String street, Integer number,Integer idAddress,
                              String boroughs, String city, String state) {

    public static CompleteAddress from(String street, Integer number, Integer idAddress,
                                       String boroughs, String city, String state){

        return new CompleteAddress(street,number,idAddress,boroughs,city,state);
    }
}
