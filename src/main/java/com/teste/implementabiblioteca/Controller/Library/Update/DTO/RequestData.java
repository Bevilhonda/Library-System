package com.teste.implementabiblioteca.Controller.Library.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestData {
    @JsonProperty("id_biblioteca")
    Integer id_biblioteca;
    @JsonProperty("nome")
    @NotBlank(message = "Falta escolher o Nome da Biblioteca.")
    String nome;
    @JsonProperty("rua")
    @NotBlank(message = "Falta escolher a Rua da Biblioteca.")
    private String rua;
    @JsonProperty("numero")
    @NotNull(message = "Falta escolher o Número do endreço da Biblioteca.")
    private Integer numero;
    @JsonProperty("bairro")
    @NotBlank(message = "Falta escolher o Bairro da Biblioteca.")
    private String bairro;
    @JsonProperty("cidade")
    @NotBlank(message = "Falta escolher a Cidade da Biblioteca.")
    private String cidade;
    @JsonProperty("estado")
    private String estado;

    public RequestData(Integer id_biblioteca, String nome, String rua, Integer numero,
                       String bairro, String cidade, String estado) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public LibraryEntity toModel(){
        return new LibraryEntity(id_biblioteca,nome,rua,numero,cidade,bairro,estado);
    }

    public Integer getId_biblioteca() {
        return id_biblioteca;
    }

    public String getNome() {
        return nome;
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
