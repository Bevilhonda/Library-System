package com.teste.implementabiblioteca.Controller.Address.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;

import javax.validation.constraints.*;

public class RequestData {

    @JsonProperty("id_endereco")
    private Integer id_endereco;

    @JsonProperty("rua")
    @NotBlank(message = "O campo 'Rua' é obrigatório.")
    private String rua;
    @JsonProperty("numero")
    @NotNull(message = "O número da residência é obrigatório.")
    private Integer numero;

    @JsonProperty("bairro")
    @NotBlank(message = "O campo 'bairro' é obrigatório.")
    private String bairro;
    @JsonProperty("cidade")
    @NotBlank(message = "O campo 'cidade' é obrigatório.")
    private String cidade;
    @JsonProperty("estado")
    @NotBlank(message = "O campo 'estado' é obrigatório.")
    private String estado;

    public RequestData(Integer idAddress, String street, Integer number,
                       String city, String boroughs, String state) {
        this.cidade = city;
        this.rua = street;
        this.numero = number;
        this.id_endereco = idAddress;
        this.estado = state;
        this.bairro = boroughs;
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
