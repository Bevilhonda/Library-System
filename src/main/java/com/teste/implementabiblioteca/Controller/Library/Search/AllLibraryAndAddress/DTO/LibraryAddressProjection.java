package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

public interface LibraryAddressProjection {
    Integer getId_biblioteca();

    String getNome();

    Integer getFk_endereco();

    String getRua();

    Integer getNumero();

    String getBairro();

    String getCidade();

    String getEstado();
}
