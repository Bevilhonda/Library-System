package com.teste.implementabiblioteca.Model.Library;

import javax.persistence.*;

@Entity
@Table(name = "Biblioteca")

public class LibraryEntity {

    public LibraryEntity() {

    }

    public LibraryEntity(Integer id_biblioteca, String nome, String rua, Integer numero,
                         String cidade, String bairro, String estado) {
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_biblioteca")
    Integer id_biblioteca;
    @Column(name = "nome")
    String nome;
    @Column(name = "rua")
    String rua;
    @Column(name = "numero")
    Integer numero;
    @Column(name = "cidade")
    String cidade;
    @Column(name = "bairro")
    String bairro;
    @Column(name = "estado")
    String estado;

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

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }
}
