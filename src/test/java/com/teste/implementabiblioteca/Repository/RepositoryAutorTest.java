package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
class RepositoryAutorTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    RepositoryAuthor repository;
    @Test
    public void Mostra_autor(){
        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));
        repository.saveAuthor(1,"Jorge", "Batista", data_nascimento_autor);

        List<AuthorEntity> autorlist = repository.GetAllAuthors(); // testando a função que retorna todos autores
        assertThat(autorlist).isNotNull();
        assertThat(autorlist.size()).isEqualTo(1);
        AuthorEntity atual = autorlist.get(1);
        repository.GetAuthor(1);

        assertThat(atual.getDateBirth().isEqual(data_nascimento_autor));
        assertThat(atual.getIdAuthor()).isEqualTo(1);
        assertThat(atual.getName()).isEqualTo("Jorge");
        assertThat(atual.getLastname()).isEqualTo("Batista");

    }

    @Test
    public void Save_Autor() {

        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));

        repository.saveAuthor(1,"Lucas", "Batista", data_nascimento_autor);

        List<AuthorEntity> autorlist = repository.GetAllAuthors(); // testando a função que retorna todos autores
        assertThat(autorlist).isNotNull();
        assertThat(autorlist.size()).isEqualTo(1);
        AuthorEntity atual = autorlist.get(0);

        assertThat(atual.getDateBirth().isEqual(data_nascimento_autor));
        assertThat(atual.getIdAuthor()).isEqualTo(1);
        assertThat(atual.getName()).isEqualTo("Lucas");
        assertThat(atual.getLastname()).isEqualTo("Batista");
    }

    @Test
    public void Update_Autor(){
        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));
        repository.saveAuthor(1,"Pedro","Batista",data_nascimento_autor);
        List<AuthorEntity> lista_de_autores = repository.GetAllAuthors();

        repository.updateAuthor("Pedro","Batista",data_nascimento_autor,1);
        assertThat(lista_de_autores).isNotNull();
        assertThat(lista_de_autores.size()).isEqualTo(1);
        AuthorEntity atual = lista_de_autores.get(0);

        assertThat(atual.getDateBirth().isEqual(data_nascimento_autor));
        assertThat(atual.getIdAuthor()).isEqualTo(1);
        assertThat(atual.getName()).isEqualTo("Pedro");
        assertThat(atual.getLastname()).isEqualTo("Batista");

    }

    @Test
    public void Deletar_autor(){
        // Incluir um autor no banco
        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));
        repository.saveAuthor(1,"Pedro","Batista",data_nascimento_autor);
        // deletar o autor do banco
        repository.deleteAuthor(1);
        //olhar no banco se tem algum autor
        List<AuthorEntity> novo = repository.GetAllAuthors();
        assertThat(novo).isEmpty();
    }


    @Test
    public void Test_Delete_Autor(){
        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));
        repository.saveAuthor(1,"Pedro","Batista",data_nascimento_autor);

        repository.deleteAuthor(1);

        List<AuthorEntity> lista_de_autores = repository.GetAllAuthors();
        assertThat(lista_de_autores.size()).isEqualTo(0);

    }


    @Test
    public void Delete_Um_Autor(){
        LocalDate data_nascimento_autor = LocalDate.from(LocalDateTime.parse("2018-10-15"));
        repository.saveAuthor(1,"Pedro","Batista",data_nascimento_autor);
        repository.saveAuthor(2,"Jorge","Batista",data_nascimento_autor);
        repository.saveAuthor(3,"Lucas","Batista",data_nascimento_autor);

        repository.deleteAuthor(2);
        List<AuthorEntity> lista_de_autores = repository.GetAllAuthors();
        assertThat(lista_de_autores.size()).isEqualTo(2);

        AuthorEntity atual = lista_de_autores.get(0);

        assertThat(atual.getDateBirth()).isEqualTo(data_nascimento_autor);
        assertThat(atual.getIdAuthor()).isEqualTo(1);
        assertThat(atual.getName()).isEqualTo("Pedro");
        assertThat(atual.getLastname()).isEqualTo("Batista");

        AuthorEntity atual1 = lista_de_autores.get(1);

        assertThat(atual1.getDateBirth()).isEqualTo(data_nascimento_autor);
        assertThat(atual1.getIdAuthor()).isEqualTo(3);
        assertThat(atual1.getName()).isEqualTo("Lucas");
        assertThat(atual1.getLastname()).isEqualTo("Batista");

    }
}