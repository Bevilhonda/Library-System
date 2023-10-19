package com.teste.implementabiblioteca.Repository.Address;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestUpgrade {
    @Autowired
    RepositoryAddress repository;

    @Test
    void update() {

        Integer addressTest = repository.saveAddress
                (
                        "Teodoro Machado",
                        20,
                        "Centro",
                        "Maringá",
                        "Paraná"
                );

        AddressEntity address = repository.getAddress(1);

        assertNotNull(addressTest);

        Integer idAddress = address.getIdAddress();

        String rua = "Barão"; String bairro = "Tokio"; String cidade = "Curitiba" ;
        String estado = "Paraná";
        Integer numero = 20;

        Integer actualAddress = repository.updateAddress(rua,numero,bairro,cidade,estado,idAddress);

        AddressEntity novo = repository.getAddress(1);

        System.out.println(novo.getStreet());

    }
}
