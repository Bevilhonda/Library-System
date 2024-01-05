package com.teste.implementabiblioteca.Model.Address;

import javax.persistence.*;

@Entity
@Table(name = "Endereco")

public class AddressEntity {

    public AddressEntity() {

    }

    public AddressEntity(Integer id_endereco, String rua, Integer numero,
                         String cidade, String bairro, String estado) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.id_endereco = id_endereco;
        this.estado = estado;
        this.bairro = bairro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id_endereco")
    private Integer id_endereco;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
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

    public String getBoroughs() {
        return bairro;
    }

    public String getCity() {
        return cidade;
    }

    public String getState() {
        return estado;
    }

}
