package com.teste.implementabiblioteca.Controller.Address.Search.AllAddress.DTO;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;

import java.util.List;

public record Response(List<FullAddress> addressList) {

    public static Response from(List<AddressEntity> listAddress) {

        List<FullAddress> list =
                listAddress.stream().map
                        (address -> FullAddress.createFullAddress
                                (address.getStreet(),
                                        address.getNumber(),
                                        address.getBoroughs(),
                                        address.getCity(),
                                        address.getState())).toList();

        return new Response(list);
    }
}
