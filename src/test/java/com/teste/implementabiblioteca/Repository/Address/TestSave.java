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
class TestSave {
    @Autowired
    RepositoryAddress repository;

    @Test
    void save() {
        Integer addressTest = repository.saveAddress
                (
                        "Teodoro Machado",
                        20,
                        "Centro",
                        "Maringá",
                        "Paraná"
                );

        AddressEntity address = repository.getAddress(1);

        assertNotNull(addressTest); // verifica se realmente inseriu o endereço
        assertEquals(1, addressTest.intValue()); /*  se o metodo save funcionou ,
        vai retornar o valor 1 e vai comparar com o valor de addressTest */


        System.out.println(address.getStreet());
        System.out.println(address.getIdAddress());

    }
}