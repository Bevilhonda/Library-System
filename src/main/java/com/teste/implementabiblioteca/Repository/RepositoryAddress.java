package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;
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
public interface RepositoryAddress extends JpaRepository<AddressEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "Insert into Endereco( rua,numero,bairro,cidade,estado) values " +
            "(:rua,:numero,:bairro,:cidade,:estado)",nativeQuery = true)
    Integer saveAddress( String rua , Integer numero, String bairro, String cidade, String estado);
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Endereco set rua = :rua , numero = :numero , cidade = :cidade ," +
            " bairro = :bairro , estado = :estado  where id_endereco = :id_endereco", nativeQuery = true)
    Integer updateAddress(String rua , Integer numero, String cidade, String bairro, String estado, Integer id_endereco);

    @Modifying(clearAutomatically = true)
    @Query(value = "Delete from Endereco where id_endereco = :id_endereco",nativeQuery = true)
    Integer deleteAddress(Integer id_endereco);

    @Query(value = "select * from Endereco where id_endereco = :id_endereco ", nativeQuery = true)
    AddressEntity getAddress(Integer id_endereco);

    @Query(value = "Select * from Endereco",nativeQuery = true )
    List<AddressEntity> getAllAddress();

}
