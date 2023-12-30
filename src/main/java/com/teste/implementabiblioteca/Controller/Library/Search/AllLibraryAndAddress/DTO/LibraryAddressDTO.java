package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

public class LibraryAddressDTO {

    private final Integer id_biblioteca;
    private final String nome;
    private final Integer fk_endereco;
    private final String rua;
    private final Integer numero;
    private final String bairro;
    private final String cidade;
    private final String estado;

    public LibraryAddressDTO(Integer idLibrary, String name, Integer fkEndereco, String street, Integer number, String neighborhoods, String city, String state) {
        this.id_biblioteca = idLibrary;
        this.nome = name;
        this.fk_endereco = fkEndereco;
        this.rua = street;
        this.numero = number;
        this.bairro = neighborhoods;
        this.cidade = city;
        this.estado = state;
    }

    public Integer getId_biblioteca() {
        return id_biblioteca;
    }

    public String getNome() {
        return nome;
    }

    public Integer getFk_endereco() {
        return fk_endereco;
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
