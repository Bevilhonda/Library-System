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
    @NotBlank(message = "Falta digitar o nome da Biblioteca.")
    String nome;
    @JsonProperty("rua")
    @NotBlank(message = "Falta Digitar o nome da Rua ou Avenida.")
    private String rua;
    @JsonProperty("numero")
    @NotNull(message = "Falta digitar o numero do endereço.")
    private Integer numero;
    @JsonProperty("bairro")
    @NotBlank(message = "Falta digitar o nome do Bairro.")
    private String bairro;
    @JsonProperty("cidade")
    @NotBlank(message = "Falta escolher a Cidade.")
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
