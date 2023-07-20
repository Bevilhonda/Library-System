package com.teste.implementabiblioteca.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class BibliotecaEntity {

    @Id
    @GeneratedValue

    String nome_da_biblioteca;
    Integer fk_endereco;
}
