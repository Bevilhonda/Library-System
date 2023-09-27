package com.teste.implementabiblioteca.Controller.Address.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;

import javax.validation.constraints.*;

public class DataAddressEntity {

    @JsonProperty("id_endereco")
    private Integer id_endereco;

    @JsonProperty("rua")
    @NotBlank(message = "O campo 'Rua' é obrigatório.")
    private String rua;
    @JsonProperty("numero")
    @NotNull(message = "O número da casa não pode ser nulo.")
    private Integer numero;

    @JsonProperty("bairro")
    @NotBlank(message = "O campo 'Bairro' é obrigatório.")
    private String bairro;
    @JsonProperty("cidade")
    @NotBlank(message = "O campo 'Cidade' é obrigatório.")
    private String cidade;
    @JsonProperty("estado")
    @NotBlank(message = "O campo 'Estado' é obrigatório.")
    private String estado;

    public DataAddressEntity(Integer idAddress, String street, Integer number,
                             String city, String zone, String state) {
        this.cidade = city;
        this.rua = street;
        this.numero = number;
        this.id_endereco = idAddress;
        this.estado = state;
        this.bairro = zone;
    }

    public AddressEntity toModel() {
        return new AddressEntity(id_endereco, rua, numero,
                cidade, bairro, estado);
    }

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
