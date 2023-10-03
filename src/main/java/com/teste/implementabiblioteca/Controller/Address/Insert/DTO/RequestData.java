package com.teste.implementabiblioteca.Controller.Address.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestData {
    @JsonProperty("id_endereco")
    private Integer id_endereco;

    @JsonProperty("rua")
    @NotBlank(message = "O campo 'rua' é obrigatório.")
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
    private String estado;

    public RequestData(Integer id_endereco, String rua, Integer numero,
                       String bairro, String cidade, String estado) {
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public AddressEntity toModel() {
        return new AddressEntity(id_endereco, rua, numero,
                cidade, bairro, estado);
    }
    public Integer getId_endereco() {
        return id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
