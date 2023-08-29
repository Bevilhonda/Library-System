package com.teste.implementabiblioteca.Model.Address;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")

public class AddressEntity {

    public AddressEntity() {

    }

    public AddressEntity(Integer idAddress, String street, Integer number,
                         String city, String zone, String state) {
        this.cidade = city;
        this.rua = street;
        this.numero = number;
        this.id_endereco = idAddress;
        this.estado = state;
        this.bairro = zone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id_endereco;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Integer getIdAddress() {
        return id_endereco;
    }

    public String getStreet() {
        return rua;
    }

    public Integer getNumber() {
        return numero;
    }

    public String getZone() {
        return bairro;
    }

    public String getCity() {
        return cidade;
    }

    public String getState() {
        return estado;
    }
}
