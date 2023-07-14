package com.teste.implementabiblioteca;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Classe_Main_SQL {

    public static void main(String[] args) {
        Instant data_nascimento_autor1 = LocalDateTime.parse("1975-03-10t20:30:00").toInstant(ZoneOffset.UTC);
        Instant data_nascimento_autor5 = LocalDateTime.parse("1965-01-10t20:30:00").toInstant(ZoneOffset.UTC);

        Autor autor = new Autor("Mendes", "Sá", data_nascimento_autor1, 251);
        Autor autor1 = new Autor("Fred", "Smith", data_nascimento_autor5, 272);

        Instant data_publicacao = LocalDateTime.parse("1990-05-25t20:30:00").toInstant(ZoneOffset.UTC);

        Livro livro = new Livro("Mundo java novo", autor1, data_publicacao, 1, 1, 531);

        //livro.Print_Livro();// aqui imprime os livros cadastrados no banco

        Funcoes_SQL insert = new Funcoes_SQL();

        //XXXX AQUI é feito um SELECT de livro do banco mysql -- 100% testado
        //insert.Comando_Select();

        //XXXX Aqui insere Livros no banco de dados mysql.-- 100 testado

        //insert.Comando_Insert(livro);

        //XXXXX Aqui atualiza dados do com.teste.implementabiblioteca.Livro no banco mysql. -- 100%testado

        //insert.Comando_Update(livro);

        //XXXXX Aqui exclui livros no banco de dados mysql -- 100% testado

        //insert.Comando_Delete(521);

        // XXXXX Aqui seleciona um livro no banco ao escolher um numero de ID -- 100% testado

        // insert.Comando_Select_Por_Id();

        //XXXXX Aqui seleciona todos os livros de um autor ao escolher o ID do autor -- 100% testado

        // insert.Comando_Select_Autores();

        //XXXXX Aqui insere um autor no Banco mysql -- 100% testado

        // insert.Comando_Insert_Autor(autor);

        //XXXX Aqui atualizada dados do com.teste.implementabiblioteca.Autor no Banco mysql -- 100% testado

        // insert.Comando_Update_Autor(autor2);

        Inserir_Autor_No_Banco input_autor = new Inserir_Autor_No_Banco();//CADASTRA UM AUTOR NO BANCO -- 100% testado
        //input_autor.Inserir_Autor();

        Inserir_Endereco_No_Banco novo_endereco = new Inserir_Endereco_No_Banco();// CADASTRA UM ENDEREÇO NO BANCO -- 100% testado
        //novo_endereco.Inserir_Dados_Endereco();

        Seleciona_Dados_Livro_No_Banco mostra_livro = new Seleciona_Dados_Livro_No_Banco();// PESQUISA LIVRO NO BANCO -- 100% testado
        //mostra_livro.Seleciona_LivroBanco();

    }
}
