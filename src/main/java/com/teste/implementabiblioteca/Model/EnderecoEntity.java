package com.teste.implementabiblioteca.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class EnderecoEntity {
    @Id
    @GeneratedValue

    String rua;
    Integer numero;
    String bairro;
    String cidade;
    String estado;
}
