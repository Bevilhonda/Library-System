package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
@Service
public interface RepositoryAddress extends JpaRepository<AddressEntity, Integer> {

    @Query(value = "select * from Endereco where id_endereco = :id_endereco ", nativeQuery = true)
    AddressEntity GetAddress(Integer id_endereco);

    @Modifying
    @Query(value = "Insert into Endereco( id_endereco,rua,numero,bairro,cidade,estado) values " +
            "(:id_endereco,:rua,:numero,:bairro,:cidade,:estado)",nativeQuery = true)
    Integer Insert(Integer id_endereco, String rua , Integer numero,String bairro, String cidade,String estado);
    @Modifying
    @Query(value = "UPDATE Endereco set rua = :rua , numero = :numero , bairro = :bairro ," +
            " cidade = :cidade , estado = :estado  where id_endereco = :id_endereco", nativeQuery = true)
    Integer UpdateAddress(String rua , Integer numero,String bairro, String cidade,String estado, Integer id_endereco);
}
