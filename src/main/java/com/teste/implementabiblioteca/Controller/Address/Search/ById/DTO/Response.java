package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;

public record Response(Integer id_endereco, FullAddress fullAddress, String cidade, String estado) {
    public static Response from(AddressEntity address) {
        FullAddress fullAddress = FullAddress.createFullAddress
                (address.getStreet(), address.getNumber(), address.getNeighborhood());

        return new Response(address.getIdAddress(), fullAddress, address.getCity(), address.getState());
    }
}
