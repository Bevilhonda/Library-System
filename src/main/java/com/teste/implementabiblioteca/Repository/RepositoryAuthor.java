package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
@Service
public interface RepositoryAuthor extends JpaRepository<AuthorEntity, Integer> {
    @Query(value = "SELECT * from Autor where id_autor = :id_autor ", nativeQuery = true)
    AuthorEntity getAuthor(Integer id_autor);

    @Query(value = "SELECT * from Autor ", nativeQuery = true)
    List<AuthorEntity> getAllAuthors();

    @Query(value = "Select * from Autor where sobrenome = :sobrenome", nativeQuery = true)
    List<AuthorEntity> getByLastName(String sobrenome);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into Autor ( nome, sobrenome, data_nascimento)" +
            " values ( :nome , :sobrenome, :data_nascimento)", nativeQuery = true)
    Integer save(String nome, String sobrenome, LocalDate data_nascimento);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Autor set nome = :nome , sobrenome = :sobrenome , data_nascimento = :data_nascimento " +
            " where id_autor = :id_autor", nativeQuery = true)
    Integer updateAuthor(String nome, String sobrenome, LocalDate data_nascimento, Integer id_autor);

    @Modifying(clearAutomatically = true)
    @Query(value = "Delete from Autor where id_autor = :id_autor", nativeQuery = true)
    Integer deleteAuthor(Integer id_autor);

    @Query(value = "SELECT * FROM Autor WHERE data_nascimento BETWEEN :dataInicial AND :dataFinal ", nativeQuery = true)
    List<AuthorEntity> getByDate(@Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
}
