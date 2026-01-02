package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
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

    @Query(value = "SELECT lib.id_biblioteca, lib.nome, lib.fk_endereco, end.rua, end.numero, end.bairro, end.cidade, end.estado " +
            "FROM Biblioteca lib " +
            "LEFT JOIN Endereco end ON lib.fk_endereco = end.id_endereco", nativeQuery = true)
    List<LibraryEntity> findAllBibliotecas();

    @Query(value = "select * from Biblioteca ", nativeQuery = true)
    List<LibraryEntity> getAllLibrary();


    @Modifying(clearAutomatically = true)
    @Query(value = "Insert into Biblioteca (nome,rua,numero,bairro,cidade,estado) values " +
            "(:nome,:rua,:numero,:bairro,:cidade,:estado) ",nativeQuery = true)
    Integer saveLibrary(String nome ,String rua, Integer numero,String bairro,String cidade,
                        String estado);

    @Modifying(clearAutomatically = true)
    @Query(value = "Update Biblioteca set nome = :nome , rua = :rua , numero = :numero, " +
            "bairro = :bairro , cidade = :cidade, estado = :estado " +
            "where id_biblioteca = :id_biblioteca ",nativeQuery = true)
    Integer update(String nome,String rua, Integer numero,String bairro,String cidade,
                   String estado, Integer id_biblioteca);

    @Modifying(clearAutomatically = true)
    @Query(value = "Delete from Biblioteca where id_biblioteca = :id_biblioteca",nativeQuery = true)
    Integer delete(Integer id_biblioteca);
}
