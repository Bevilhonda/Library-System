package com.teste.implementabiblioteca;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserir_Endereco_No_Banco {
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public void Inserir_Dados_Endereco() {

        String adiciona_endereco =
                "insert into Endereco(rua,numero,bairro,cidade,estado) values(?,?,?,?,?);";

        try {

            JOptionPane.showMessageDialog
                    (null, "Olá !  Tudo bem ? Benvindo ao Mundo JAVA , vamos inserir um " +
                            "endereço no Banco de dados");
            rua = JOptionPane.showInputDialog
                    ("Agora por favor insira o nome da rua :");
            numero = Integer.parseInt(JOptionPane.showInputDialog
                    ("Agora por favor insira o numero do endereço :"));
            bairro = JOptionPane.showInputDialog
                    ("Agora por favor insira o nome do bairro :");
            cidade = JOptionPane.showInputDialog
                    ("Agora por favor insira o nome da cidade :");
            estado = JOptionPane.showInputDialog
                    ("Agora por favor insira o nome do estado :");

            Conection_Mysql conecta = new Conection_Mysql();

            Connection conecta_banco = conecta.getconection();

            PreparedStatement insere_dados_endereco = conecta_banco.prepareStatement(adiciona_endereco);

            insere_dados_endereco.setString(1, rua);
            insere_dados_endereco.setInt(2, getNumero());
            insere_dados_endereco.setString(3, bairro);
            insere_dados_endereco.setString(4, cidade);
            insere_dados_endereco.setString(5, estado);


            insere_dados_endereco.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
