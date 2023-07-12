package com.teste.implementabiblioteca;

import com.teste.implementabiblioteca.Conection_Mysql;

import java.sql.*;
import java.util.Scanner;

public class Pesquisa_LivroBanco {
    int id_livro;

    public void Seleciona_LivroBanco() {
        String busca_livro = "select * from com.teste.implementabiblioteca.Livro where id_Livro = ? ";

        try {
            Scanner input_id_livro = new Scanner(System.in);
            System.out.println("Digite um numero de id do banco de Livros :");
            id_livro = input_id_livro.nextInt();

            Conection_Mysql conecta = new Conection_Mysql();

            Connection conecta_banco = conecta.getconection();

            PreparedStatement seleciona_livro = conecta_banco.prepareStatement(busca_livro);
            seleciona_livro.setInt(1,getId_livro());

            ResultSet mostra_livro = seleciona_livro.executeQuery();
            while (mostra_livro.next()){
                System.out.println(mostra_livro.getString("id_Livro"));
                System.out.println(mostra_livro.getString("titulo"));
                System.out.println(mostra_livro.getInt(3));
                System.out.println(mostra_livro.getDate( 6));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getId_livro() {
        return id_livro;
    }
}
