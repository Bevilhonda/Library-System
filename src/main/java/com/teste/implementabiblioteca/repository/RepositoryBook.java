package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public interface RepositoryBook extends JpaRepository<BookEntity, Integer> {

    @Query(value = "select * from Livro where id_Livro = :id_Livro", nativeQuery = true)
    BookEntity GetBook(Integer id_Livro);

    @Query(value = "select * from Livro ", nativeQuery = true)
    List<BookEntity> GetAllBooks();

    @Query(value = "select * from Livro JOIN Autor ON " +
            "Livro.fk_autor = Autor.id_autor JOIN Biblioteca ON " +
            "Livro.fk_biblioteca = Biblioteca.id_biblioteca  JOIN Endereco ON" +
            " Biblioteca.fk_endereco = Endereco.id_endereco  ", nativeQuery = true)
    List<BookEntity> GetBooksByID();

}
