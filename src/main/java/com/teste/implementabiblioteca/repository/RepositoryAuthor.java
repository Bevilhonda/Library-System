package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Repository
@Transactional
@Service
public interface RepositoryAuthor extends JpaRepository<AuthorEntity, Integer> {
    @Query(value = "SELECT * from Autor where id_autor = :id_autor ", nativeQuery = true)
    AuthorEntity GetAuthor(Integer id_autor);

    @Query(value = "SELECT * from Autor ", nativeQuery = true)
    List<AuthorEntity> GetAllAuthors();

    @Query(value = "Select * from Autor where sobrenome = :sobrenome" , nativeQuery = true)
    List<AuthorEntity> GetAuthorByLastName(String sobrenome);


    @Query(value = "Insert into Autor (id_autor ,nome, sobrenome, data_nascimento) values " +
            "(:id_autor ,:nome, :sobrenome, :data_nascimento)", nativeQuery = true)
    @Modifying
    Integer saveAuthor(Integer id_autor,String nome,String sobrenome,Instant data_nascimento);

    @Modifying
    @Query(value = "UPDATE Autor set nome = :nome , sobrenome = :sobrenome , data_nascimento = :data_nascimento " +
            " where id_autor = :id_autor", nativeQuery = true)
    Integer updateAuthor(String nome, String sobrenome, Instant data_nascimento, Integer id_autor);

    @Modifying
    @Query (value = "Delete from Autor where id_autor = :id_autor" , nativeQuery = true)
    Integer deleteAuthor(Integer id_autor);

    @Modifying
    @Query(value = "SELECT * FROM Autor WHERE data_nascimento BETWEEN :dataInicial AND :dataFinal ", nativeQuery = true)
    List<AuthorEntity> selectAuthorByDate(@Param("dataInicial") Instant dataInicial, @Param("dataFinal") Instant dataFinal);
}
