package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AutorEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
class RepositoryAutorTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    RepositoryAutor repository;
    @Test
    public void Mostra_autor(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        repository.Inclui_Autor(1,"Jorge", "Batista", data_nascimento_autor);

        List<AutorEntity> autorlist = repository.TodosAutores(); // testando a função que retorna todos autores
        assertThat(autorlist).isNotNull();
        assertThat(autorlist.size()).isEqualTo(1);
        AutorEntity atual = autorlist.get(0);
        repository.GetAutor(1);

        assertThat(atual.getData_nascimento()).isEqualTo(data_nascimento_autor);
        assertThat(atual.getId_autor()).isEqualTo(1);
        assertThat(atual.getNome()).isEqualTo("Jorge");
        assertThat(atual.getSobrenome()).isEqualTo("Batista");

    }

    @Test
    public void Save_Autor() {

        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);

        repository.Inclui_Autor(1,"Lucas", "Batista", data_nascimento_autor);

        List<AutorEntity> autorlist = repository.TodosAutores(); // testando a função que retorna todos autores
        assertThat(autorlist).isNotNull();
        assertThat(autorlist.size()).isEqualTo(1);
        AutorEntity atual = autorlist.get(0);

        assertThat(atual.getData_nascimento()).isEqualTo(data_nascimento_autor);
        assertThat(atual.getId_autor()).isEqualTo(1);
        assertThat(atual.getNome()).isEqualTo("Lucas");
        assertThat(atual.getSobrenome()).isEqualTo("Batista");
    }

    @Test
    public void Update_Autor(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        repository.Inclui_Autor(1,"Pedro","Batista",data_nascimento_autor);
        List<AutorEntity> lista_de_autores = repository.TodosAutores();

        repository.Update_Autor("Pedro","Batista",data_nascimento_autor,1);
        assertThat(lista_de_autores).isNotNull();
        assertThat(lista_de_autores.size()).isEqualTo(1);
        AutorEntity atual = lista_de_autores.get(0);

        assertThat(atual.getData_nascimento()).isEqualTo(data_nascimento_autor);
        assertThat(atual.getId_autor()).isEqualTo(1);
        assertThat(atual.getNome()).isEqualTo("Pedro");
        assertThat(atual.getSobrenome()).isEqualTo("Batista");

    }

    @Test
    public void Deletar_autor(){
        // Incluir um autor no banco
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        repository.Inclui_Autor(1,"Pedro","Batista",data_nascimento_autor);
        // deletar o autor do banco
        repository.Delete_Autor(1);
        //olhar no banco se tem algum autor
        List<AutorEntity> novo = repository.TodosAutores();
        assertThat(novo).isEmpty();
    }


    @Test
    public void Test_Delete_Autor(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        repository.Inclui_Autor(1,"Pedro","Batista",data_nascimento_autor);

        repository.Delete_Autor(1);

        List<AutorEntity> lista_de_autores = repository.TodosAutores();
        assertThat(lista_de_autores.size()).isEqualTo(0);

    }


    @Test
    public void Delete_Um_Autor(){
        Instant data_nascimento_autor = LocalDateTime.parse("2018-10-15t20:30:00").toInstant(ZoneOffset.UTC);
        repository.Inclui_Autor(1,"Pedro","Batista",data_nascimento_autor);
        repository.Inclui_Autor(2,"Jorge","Batista",data_nascimento_autor);
        repository.Inclui_Autor(3,"Lucas","Batista",data_nascimento_autor);

        repository.Delete_Autor(2);
        List<AutorEntity> lista_de_autores = repository.TodosAutores();
        assertThat(lista_de_autores.size()).isEqualTo(2);

        AutorEntity atual = lista_de_autores.get(0);

        assertThat(atual.getData_nascimento()).isEqualTo(data_nascimento_autor);
        assertThat(atual.getId_autor()).isEqualTo(1);
        assertThat(atual.getNome()).isEqualTo("Pedro");
        assertThat(atual.getSobrenome()).isEqualTo("Batista");

        AutorEntity atual1 = lista_de_autores.get(1);

        assertThat(atual1.getData_nascimento()).isEqualTo(data_nascimento_autor);
        assertThat(atual1.getId_autor()).isEqualTo(3);
        assertThat(atual1.getNome()).isEqualTo("Lucas");
        assertThat(atual1.getSobrenome()).isEqualTo("Batista");

    }
}