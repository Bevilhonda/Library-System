package com.teste.implementabiblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

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


    @JsonProperty("id_endereco")
    private Integer id_endereco;

    private String rua;
    @JsonProperty("numero")
    private Integer numero;

    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("estado")
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
