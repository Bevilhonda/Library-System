package com.teste.implementabiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name =  "Biblioteca")

public class LibraryEntity {

    public LibraryEntity(){

    }
    public LibraryEntity(Integer id_biblioteca , String nome , Integer fk_endereco){
        this.id_biblioteca = id_biblioteca;
        this.nome = nome;
        this.fk_endereco = fk_endereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id_biblioteca ;
    String nome;
    Integer fk_endereco;

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
