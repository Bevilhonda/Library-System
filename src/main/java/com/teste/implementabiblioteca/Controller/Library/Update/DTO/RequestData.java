package com.teste.implementabiblioteca.Controller.Library.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestData {
    @JsonProperty("id_biblioteca")
    Integer id_biblioteca;
    @JsonProperty("nome")
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    String nome;
    @JsonProperty("fk_endereco")
    @NotNull(message = "O número do Id de endereço é obrigatório.")
    Integer fk_endereco;

    public RequestData(Integer id_biblioteca, String nome, Integer fk_endereco) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.fk_endereco = fk_endereco;
    }

    public LibraryEntity toModel(){
        return new LibraryEntity(id_biblioteca,nome,fk_endereco);
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
}
