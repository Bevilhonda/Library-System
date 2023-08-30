package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
@Service
public interface RepositoryBook extends JpaRepository<BookEntity, Integer> {

    @Query(value = "select * from Livro where id_Livro = :id_Livro", nativeQuery = true)
    BookEntity getBook(Integer id_Livro);

    @Query(value = "select * from Livro ", nativeQuery = true)
    List<BookEntity> getAllBooks();

    @Query(value = "select * from Livro JOIN Autor ON " +
            "Livro.fk_autor = Autor.id_autor where id_Livro = :id_Livro ", nativeQuery = true)
    List<BookEntity> getBookAuthor(Integer id_Livro);

    @Query(value = "select * from Livro JOIN Autor ON " +
            "Livro.fk_autor = Autor.id_autor JOIN Biblioteca ON " +
            "Livro.fk_biblioteca = Biblioteca.id_biblioteca  JOIN Endereco ON" +
            " Biblioteca.fk_endereco = Endereco.id_endereco  ", nativeQuery = true)
    List<BookEntity> getBooksByID();

    @Modifying
    @Query(value = "Insert into Livro (titulo,data_publication,edicao,fk_autor,fk_biblioteca)" +
            "values (:titulo ,:data_publication ,:edicao ,:fk_autor ,:fk_biblioteca )",nativeQuery = true)
    Integer save(String titulo, LocalDate data_publication,Integer edicao,Integer fk_autor,Integer fk_biblioteca);

    @Modifying
    @Query(value = "Update Livro set titulo = :titulo , data_publication = :data_publication , edicao = :edicao " +
            "where id_Livro = :id_Livro ", nativeQuery = true )
    Integer update(String titulo, LocalDate data_publication,Integer edicao,Integer id_Livro);

    @Modifying
    @Query(value = "Delete from Livro where id_Livro = :id_Livro ", nativeQuery = true)
    Integer delete(Integer id_Livro);
}
