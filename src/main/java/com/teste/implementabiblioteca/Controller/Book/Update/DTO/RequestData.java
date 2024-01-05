package com.teste.implementabiblioteca.Controller.Book.Update.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Book.BookEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class RequestData {
    @JsonProperty("id_Livro")
    private Integer id_Livro;
    @JsonProperty("titulo")
    @NotBlank(message = "O campo 'Titulo' é obrigatório.")
    private String titulo;
    @JsonProperty("edicao")
    @NotNull(message = "O número da edição é obrigatório.")
    private Integer edicao;
    @JsonProperty("fk_autor")
    private Integer fk_autor;
    @JsonProperty("fk_biblioteca")
    private Integer fk_biblioteca;
    @JsonProperty("data_publication")
    @NotNull(message = "A data de publicação é obrigatório.")
    @Past(message = "A data de publicação é inválida.")
    private LocalDate data_publication;

    public RequestData(String titulo, LocalDate data_publication, Integer edicao,  Integer id_Livro) {
        this.id_Livro = id_Livro;
        this.titulo = titulo;
        this.edicao = edicao;
        this.data_publication = data_publication;
    }

    public BookEntity toModel() {
        return new BookEntity(titulo, data_publication, edicao, fk_autor,fk_biblioteca, id_Livro);
    }

    public Integer getId_Livro() {
        return id_Livro;
    }

}
