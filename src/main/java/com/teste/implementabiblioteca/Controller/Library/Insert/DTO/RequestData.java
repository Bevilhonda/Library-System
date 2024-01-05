package com.teste.implementabiblioteca.Controller.Library.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RequestData {
    @JsonProperty("id_biblioteca")
    Integer id_biblioteca;
    @JsonProperty("nome")
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    String nome;
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

    public LibraryEntity toModel() {
        return new LibraryEntity(id_biblioteca, nome,rua, numero,
                cidade, bairro, estado);
    }


}
