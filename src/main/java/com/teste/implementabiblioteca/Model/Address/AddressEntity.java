package com.teste.implementabiblioteca.Model.Address;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Endereco")

public class AddressEntity {

    public AddressEntity() {

    }

    public AddressEntity(Integer idAddress, String street, Integer number,
                         String city, String boroughs, String state) {
        this.cidade = city;
        this.rua = street;
        this.numero = number;
        this.id_endereco = idAddress;
        this.estado = state;
        this.bairro = boroughs;
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
    @OneToMany(mappedBy = "fk_endereco")
    private List<LibraryEntity> bibliotecas;

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
