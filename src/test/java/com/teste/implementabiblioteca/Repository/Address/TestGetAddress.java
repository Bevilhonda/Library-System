package com.teste.implementabiblioteca.Repository.Address;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestGetAddress {
    @Autowired
    RepositoryAddress repository;

    @Test
    void getAddress() {
        Integer addressTest = repository.saveAddress
                (
                        "Teodoro Machado",
                        20,
                        "Centro",
                        "Maringá",
                        "Paraná"
                );

        assertNotNull(addressTest);
        assertEquals(addressTest, 1);

        List<AddressEntity> listAddress = repository.getAllAddress();

        assertThat(listAddress).isNotNull();
        assertThat(listAddress.size()).isEqualTo(1);

        AddressEntity address = repository.getAddress(1);

        AddressEntity addressActual = listAddress.get(0);

        assertThat(address.getIdAddress()).isEqualTo(addressActual.getIdAddress());

        assertThat(addressActual.getIdAddress()).isEqualTo(1);
        assertThat(addressActual.getNumber()).isEqualTo(20);
        assertThat(addressActual.getBoroughs()).isEqualTo("Centro");
        assertThat(addressActual.getCity()).isEqualTo("Maringá");
        assertThat(addressActual.getState()).isEqualTo("Paraná");

    }
}
