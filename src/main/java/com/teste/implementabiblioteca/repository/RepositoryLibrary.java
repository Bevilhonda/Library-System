package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
@Service
public interface RepositoryLibrary extends JpaRepository<LibraryEntity, Integer> {

    @Query(value = "select * from Biblioteca where id_biblioteca = :id_biblioteca " , nativeQuery = true)
    LibraryEntity GetLibrary(Integer id_biblioteca);
}
