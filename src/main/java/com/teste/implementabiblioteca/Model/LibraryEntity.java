package com.teste.implementabiblioteca.Model;

import javax.persistence.*;

@Entity
@Table(name =  "Biblioteca")

public class LibraryEntity {

    public LibraryEntity(){

    }
    public LibraryEntity(Integer idLibrary , String name , Integer fkEndereco){
        this.id_biblioteca = idLibrary;
        this.nome = name;
        this.fk_endereco = fkEndereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id_biblioteca ;
    String nome;
    Integer fk_endereco;

    public String getNameLibrary() {
        return nome;
    }

    public Integer getIdLibrary() {
        return id_biblioteca;
    }

    public Integer getAddressLibrary() {
        return fk_endereco;
    }
}
