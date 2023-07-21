package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
@Service
public interface RepositoryBook extends JpaRepository<BookEntity, Integer> {

    @Query(value = "select *from Livro where id_Livro = :id_Livro", nativeQuery = true)
    BookEntity GetBook(Integer id_Livro);
}
