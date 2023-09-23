package com.teste.implementabiblioteca.Controller.Book.Insert.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teste.implementabiblioteca.Model.Book.BookEntity;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class DataBookEntity {
    @JsonProperty("id_Livro")
    private Integer id_Livro;
    @JsonProperty("titulo")
    @NotBlank(message = "O campo 'Titulo' é obrigatório.")
    private String titulo;
    @JsonProperty("edicao")
    @NotNull(message = "O número da edição não pode ser nulo.")
    @Min(value = 1, message = "O número mínimo da edição é 1.")
    @Max(value = 9999, message = "O número máximo da edição é 9999.")
    private Integer edicao;
    @JsonProperty("fk_autor")
    @NotNull(message = "O número do Id de autor não pode ser nulo.")
    @Min(value = 1, message = "O número mínimo do ID é 1.")
    @Max(value = Long.MAX_VALUE, message = "O ID máximo do usuário é infinito.")
    private Integer fk_autor;
    @JsonProperty("fk_biblioteca")
    @NotNull(message = "O número do Id de biblioteca não pode ser nulo.")
    @Min(value = 1, message = "O número mínimo do ID é 1.")
    @Max(value = Long.MAX_VALUE, message = "O ID máximo da biblioteca é infinito.")
    private Integer fk_biblioteca;
    @JsonProperty("data_publication")
    @NotNull(message = "A data de publicação não pode ser nula.")
    @Past(message = "A data de publicação é inválida.")
    private LocalDate data_publication;

    public DataBookEntity(String title, int idAuthor, LocalDate publicationDate, int edition, int idLibrary, int idBook) {
        this.id_Livro = idBook;
        this.titulo = title;
        this.edicao = edition;
        this.fk_autor = idAuthor;
        this.fk_biblioteca = idLibrary;
        this.data_publication = publicationDate;
    }

    public BookEntity toModel() {
        return new BookEntity(titulo, fk_autor, data_publication, edicao, fk_biblioteca, id_Livro);
    }

    public Integer getId_Livro() {
        return id_Livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public Integer getFk_autor() {
        return fk_autor;
    }

    public Integer getFk_biblioteca() {
        return fk_biblioteca;
    }

    public LocalDate getData_publication() {
        return data_publication;
    }
}
