package com.teste.implementabiblioteca.Controller.Book.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
public class RequestData {
    @JsonProperty("id_Livro")
    private Integer id_Livro;
    @JsonProperty("titulo")
    @NotBlank(message = "Falta digitar o titulo do Livro.")
    private String titulo;
    @JsonProperty("edicao")
    @NotNull(message = "Escolha o número da edição.")
    private Integer edicao;
    @JsonProperty("id_autor")
    @NotNull(message = "Escolha um autor.")
    private Integer fk_autor;
    @JsonProperty("id_biblioteca")
    @NotNull(message = "O número do Id de biblioteca é obrigatório.")
    private Integer fk_biblioteca;
    @JsonProperty("data_publication")
    @NotNull(message = "Escolha a data de publicação.")
    @Past(message = "Escolha uma data do presente ou passado.")
    private LocalDate data_publication;

    public RequestData(String titulo, LocalDate data_publication, Integer edicao,
                       Integer fk_autor, Integer fk_biblioteca , Integer id_Livro) {
        this.id_Livro = id_Livro;
        this.titulo = titulo;
        this.edicao = edicao;
        this.fk_autor = fk_autor;
        this.fk_biblioteca = fk_biblioteca;
        this.data_publication = data_publication;
    }

    public BookEntity toModel() {
        return new BookEntity(titulo, data_publication, edicao,fk_autor,fk_biblioteca,id_Livro);
    }

}
