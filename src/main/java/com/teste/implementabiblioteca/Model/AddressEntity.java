package com.teste.implementabiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")

public class AddressEntity {

    public AddressEntity() {

    }

    public AddressEntity(Integer idAddress , String streetName, String cityName,
                         Integer number, String zone , String state ) {
        this.cidade = cityName;
        this.rua = streetName;
        this.numero = number;
        this.id_endereco = idAddress;
        this.estado = state;
        this.bairro= zone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id_endereco;
    String rua;
    Integer numero;
    String bairro;
    String cidade;
    String estado;

    public Integer getIdAddress() {
        return id_endereco;
    }

    public String getAddress() {
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
