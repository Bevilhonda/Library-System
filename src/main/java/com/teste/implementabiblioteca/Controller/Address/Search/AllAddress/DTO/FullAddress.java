package com.teste.implementabiblioteca.Controller.Address.Search.AllAddress.DTO;

public record FullAddress(String street, Integer number, String boroughs, String city, String state) {
    public static FullAddress createFullAddress(String street, Integer number, String boroughs,String city ,String state){
        return new FullAddress(street, number, boroughs,city,state);
    }

}