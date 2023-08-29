package com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;

public class Response {
    private final Integer id_endereco;
    private final FullAddress fullAddress;
    private final String cidade;
    private final String estado;

    public Response(Integer id_endereco, FullAddress fullAddress, String cidade, String estado) {
        this.id_endereco = id_endereco;
        this.fullAddress = fullAddress;
        this.cidade = cidade;
        this.estado = estado;
    }

    public static Response from(AddressEntity address) {
        return new Response(address.getIdAddress(),
                new FullAddress(address.getStreet() + " " + address.getNumber() +
                        " " + address.getZone() + " "), address.getCity(), address.getState());

    }

    public Integer getId_endereco() {
        return id_endereco;
    }

    public FullAddress getFullAddress() {
        return fullAddress;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
