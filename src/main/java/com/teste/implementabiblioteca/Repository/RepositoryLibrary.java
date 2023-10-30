package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public interface RepositoryLibrary extends JpaRepository<LibraryEntity, Integer> {

    @Query(value = "select * from Biblioteca where id_biblioteca = :id_biblioteca ", nativeQuery = true)
    LibraryEntity getLibraryById(Integer id_biblioteca);

    @Query(value = "select * from Biblioteca where nome = :nome ", nativeQuery = true)
    List<LibraryEntity> getLibraryByName(String nome);


    @Query(value = "select * from Biblioteca ", nativeQuery = true)
    List<LibraryEntity> getAllLibrary();

    @Modifying(clearAutomatically = true)
    @Query(value = "Insert into Biblioteca (nome,fk_endereco) values " +
            "(:nome , :fk_endereco) ",nativeQuery = true)
    Integer insert(String nome , Integer fk_endereco);

    @Modifying(clearAutomatically = true)
    @Query(value = "Update Biblioteca set nome = :nome , fk_endereco = :fk_endereco " +
            "where id_biblioteca = :id_biblioteca ",nativeQuery = true)
    Integer update(String nome, Integer fk_endereco,Integer id_biblioteca);

    @Modifying(clearAutomatically = true)
    @Query(value = "Delete from Biblioteca where id_biblioteca = :id_biblioteca",nativeQuery = true)
    Integer deleteLibrary(Integer id_biblioteca);
}
