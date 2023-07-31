package com.teste.implementabiblioteca;

import java.sql.*;
import java.time.ZoneOffset;

public class Funcoes_SQL {
/*
    public void Comando_Select() {


        try {
            Conection_Mysql conectando_banco = new Conection_Mysql();

            Connection conecta_banco = conectando_banco.getconection();

            Statement nova_conexao = conecta_banco.createStatement();

            ResultSet executa_query = nova_conexao.executeQuery
                    ("select * from Livro join Autor on (Livro.fk_autor = Autor.id_autor )");

            while (executa_query.next()) {

                Autor autor1 = new Autor(executa_query.getString("nome"),
                        executa_query.getString("sobrenome"),
                        executa_query.getTimestamp("data_nascimento").toInstant(),
                        executa_query.getInt("id_autor"));

                Livro livro1 = new Livro(executa_query.getString("titulo"), autor1,
                        executa_query.getTimestamp("data_publication").toInstant(),
                        executa_query.getInt("edicao"),
                        executa_query.getInt("fk_biblioteca"),
                        executa_query.getInt("id_livro"));

                livro1.Print_Livro();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Insert(Livro novo_livro) {

        String inserir_livro =
                "insert into Livro (titulo,edicao,fk_autor,fk_biblioteca,data_publication) values(?,?,?,?,?)";

        try {

            Conection_Mysql conect = new Conection_Mysql();

            Connection conecta_banco = conect.getconection();

            PreparedStatement insere_dados = conecta_banco.prepareStatement(inserir_livro);

            insere_dados.setString(1, novo_livro.getTitulo_livro());
            insere_dados.setInt(2, novo_livro.getEdicao());
            insere_dados.setInt(3, novo_livro.getAutor().getId_autor());
            insere_dados.setInt(4, novo_livro.getId_biblioteca());
            insere_dados.setTimestamp
                    (5, Timestamp.from(novo_livro.getData_publication().atOffset
                            (ZoneOffset.UTC).toInstant()));

            insere_dados.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Update(Livro livro) {

        String atualiza_dados_livro =
                "update Livro set titulo = ? , edicao = ? , data_publication = ? where id_Livro = ? ";

        try {
            Conection_Mysql conecta_banco = new Conection_Mysql();

            Connection conexao_banco = conecta_banco.getconection();

            PreparedStatement insercao_dados = conexao_banco.prepareStatement(atualiza_dados_livro);

            insercao_dados.setString(1, livro.getTitulo_livro());
            insercao_dados.setInt(2, livro.getEdicao());
            insercao_dados.setTimestamp
                    (3, Timestamp.from(livro.getData_publication().atOffset
                            (ZoneOffset.UTC).toInstant()));
            insercao_dados.setInt(4, livro.getId_livro());

            insercao_dados.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public void Comando_Delete(int id_livro) {
        String comando_excluir = "delete from com.teste.implementabiblioteca.Livro where id_Livro = ? ";

        try {

            Conection_Mysql conecta = new Conection_Mysql();

            Connection conecta_banco = conecta.getconection();

            PreparedStatement insere_dados = conecta_banco.prepareStatement(comando_excluir);

            insere_dados.setInt(1, id_livro);

            insere_dados.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Select_Por_Id() {
        try {
            Conection_Mysql conectando_banco = new Conection_Mysql();

            Connection conecta_banco = conectando_banco.getconection();

            Statement nova_conexao = conecta_banco.createStatement();

            ResultSet executa_query = nova_conexao.executeQuery
                    ("SELECT * FROM com.teste.implementabiblioteca.Livro join com.teste.implementabiblioteca.Autor on fk_autor = id_autor WHERE id_livro = 519;");

            while (executa_query.next()) {

                Autor autor1 = new Autor(executa_query.getString("nome"),
                        executa_query.getString("sobrenome"),
                        executa_query.getTimestamp("data_nascimento").toInstant(),
                        executa_query.getInt("id_autor"));

                Livro livro1 = new Livro(executa_query.getString("titulo"), autor1,
                        executa_query.getTimestamp("data_publication").toInstant(),
                        executa_query.getInt("edicao"),
                        executa_query.getInt("fk_biblioteca"),
                        executa_query.getInt("id_livro"));
                livro1.Print_Livro();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Select_Autores() {

        try {
            Conection_Mysql conectando_banco = new Conection_Mysql();

            Connection conecta_banco = conectando_banco.getconection();

            Statement nova_conexao = conecta_banco.createStatement();

            ResultSet executa_query = nova_conexao.executeQuery
                    ("SELECT * from com.teste.implementabiblioteca.Livro join com.teste.implementabiblioteca.Autor on fk_autor = id_autor where id_autor = 240;");

            while (executa_query.next()) {

                Autor autor1 = new Autor(executa_query.getString("nome"),
                        executa_query.getString("sobrenome"),
                        executa_query.getTimestamp("data_nascimento").toInstant(),
                        executa_query.getInt("id_autor"));

                Livro livro1 = new Livro(executa_query.getString("titulo"), autor1,
                        executa_query.getTimestamp("data_publication").toInstant(),
                        executa_query.getInt("edicao"),
                        executa_query.getInt("fk_biblioteca"),
                        executa_query.getInt("id_livro"));

                livro1.Print_Livro();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Insert_Autor(Autor novo_autor) {

        String adiciona_autor =
                "insert into com.teste.implementabiblioteca.Autor (nome,sobrenome,data_nascimento) values (?,?,?)";

        try {
            Conection_Mysql conecta = new Conection_Mysql();

            Connection conecta_banco = conecta.getconection();

            PreparedStatement insere_dados_autor = conecta_banco.prepareStatement(adiciona_autor);

            insere_dados_autor.setString(1, novo_autor.getNome());
            insere_dados_autor.setString(2, novo_autor.getSobrenome());
            insere_dados_autor.setTimestamp
                    (3, Timestamp.from(novo_autor.getData_nascimento().
                            atOffset(ZoneOffset.UTC).toInstant()));


            insere_dados_autor.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public void Comando_Update_Autor(Autor novos_dados) {

        String atualiza_dados_autor =
                "UPDATE com.teste.implementabiblioteca.Autor set nome = ? ,sobrenome = ? , data_nascimento = ? WHERE id_autor = ? ";

        try {
            Conection_Mysql conecta = new Conection_Mysql();

            Connection conectando_banco = conecta.getconection();

            PreparedStatement insere_dados_autor = conectando_banco.prepareStatement(atualiza_dados_autor);

            insere_dados_autor.setString(1, novos_dados.getNome());
            insere_dados_autor.setString(2, novos_dados.getSobrenome());
            insere_dados_autor.setTimestamp
                    (3, Timestamp.from(novos_dados.getData_nascimento().
                            atOffset(ZoneOffset.UTC).toInstant()));
            insere_dados_autor.setInt(4, novos_dados.getId_autor());

            insere_dados_autor.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



 */
}