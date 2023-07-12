package com.teste.implementabiblioteca;

import com.teste.implementabiblioteca.Conection_Mysql;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input_Dados_Autor {
    String nome_autor;
    String sobrenome_autor;
    Instant data_nascimento ;

    public void Inserir_Autor() {
        String adiciona_autor =
                "insert into com.teste.implementabiblioteca.Autor (nome,sobrenome,data_nascimento) values (?,?,?)";

        try {
            Scanner dados_autor = new Scanner(System.in);
            System.out.println("Digite o nome do com.teste.implementabiblioteca.Autor");
            nome_autor = dados_autor.next();
            System.out.println("Digite o sobrenome do com.teste.implementabiblioteca.Autor");
            sobrenome_autor = dados_autor.next();
            System.out.println("Digite a idade do com.teste.implementabiblioteca.Autor:");
            data_nascimento = LocalDateTime.parse(dados_autor.next() + " 00:00:00",
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                    .toInstant(ZoneOffset.UTC);

            Conection_Mysql conecta = new Conection_Mysql();

            Connection conecta_banco = conecta.getconection();

            PreparedStatement insere_dados_autor = conecta_banco.prepareStatement(adiciona_autor);

            insere_dados_autor.setString(1,nome_autor);
            insere_dados_autor.setString(2,sobrenome_autor);
            insere_dados_autor.setTimestamp
                    (3, Timestamp.from(data_nascimento.atOffset(ZoneOffset.UTC).toInstant()));

            //(2018-10-15t20:30:00)(2018-10-15 20:30:00) 15/07/1980

            insere_dados_autor.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public String getNome_autor() {
        return nome_autor;
    }

    public String getSobrenome_autor() {
        return sobrenome_autor;
    }

    public Instant getData_nascimento() {
        return data_nascimento;
    }
}
