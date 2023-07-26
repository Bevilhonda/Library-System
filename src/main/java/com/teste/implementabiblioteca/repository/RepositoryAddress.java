package com.teste.implementabiblioteca.repository;

import com.teste.implementabiblioteca.Model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
