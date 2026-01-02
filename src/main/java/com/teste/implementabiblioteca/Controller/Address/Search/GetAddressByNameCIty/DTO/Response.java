package com.teste.implementabiblioteca.Controller.Address.Search.GetAddressByNameCIty.DTO;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;

import java.util.List;

public record Response(List<FullAddress> addressList) {

    public static Response from(List<AddressEntity> listAddress) {
        List<FullAddress> list =
                listAddress.stream().map
                        (addressEntity -> FullAddress.createAddressByCity(
                                addressEntity.getStreet(),
                                addressEntity.getNumber(),
                                addressEntity.getBoroughs(),
                                addressEntity.getCity(),
                                addressEntity.getState())).toList();
        return new Response(list);
    }
}
