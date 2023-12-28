package com.teste.implementabiblioteca.Model.Library;

import javax.persistence.*;

@Entity
@Table(name = "Biblioteca")

public class LibraryEntity {

    public LibraryEntity() {

    }

    public LibraryEntity(Integer idLibrary, String name, Integer address) {
        this.id_biblioteca = idLibrary;
        this.nome = name;
        this.fk_endereco = address;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_biblioteca")
    Integer id_biblioteca;
    @Column(name = "nome")
    String nome;
    @Column(name = "fk_endereco")
    Integer fk_endereco;

    public Integer getIdLibrary() {
        return id_biblioteca;
    }

    public String getName() {
        return nome;
    }

    public Integer getFkAddress() {
        return fk_endereco;
    }

}
