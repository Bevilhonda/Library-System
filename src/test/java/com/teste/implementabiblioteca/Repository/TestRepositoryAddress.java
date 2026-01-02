package com.teste.implementabiblioteca.Repository;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestRepositoryAddress {
    @Autowired
    RepositoryAddress repository;

    @Test
    void save() {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");

        AddressEntity address = repository.getAddress(1);

        assertThat(address.getStreet()).isEqualTo("Teodoro Machado");
        assertThat(address.getNumber()).isEqualTo(20);
        assertThat(address.getBoroughs()).isEqualTo("Centro");
        assertThat(address.getCity()).isEqualTo("Maringá");
        assertThat(address.getState()).isEqualTo("Paraná");
    }

    @Test
    void update() {
        String street = "Barão", boroughs = "Tokio", city = "Curitiba", state = "Paraná";
        Integer number = 200;

        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");

        repository.updateAddress(street, number, city, boroughs, state, 1);

        AddressEntity address = repository.getAddress(1);

        assertThat(address.getStreet()).isEqualTo("Barão");
        assertThat(address.getNumber()).isEqualTo(200);
        assertThat(address.getBoroughs()).isEqualTo("Tokio");
        assertThat(address.getCity()).isEqualTo("Curitiba");
        assertThat(address.getState()).isEqualTo("Paraná");
    }

    @Test
    void getAddress() {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");

        List<AddressEntity> listAddress = repository.getAllAddress();

        assertThat(listAddress.size()).isEqualTo(1);

        AddressEntity addressActual = listAddress.get(0);

        assertThat(addressActual.getNumber()).isEqualTo(20);
        assertThat(addressActual.getBoroughs()).isEqualTo("Centro");
        assertThat(addressActual.getCity()).isEqualTo("Maringá");
        assertThat(addressActual.getState()).isEqualTo("Paraná");
    }

    @Test
    void getAllAddress() {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");
        repository.saveAddress("Barão", 200, "Mandacaru", "Londrina", "Paraná");

        List<AddressEntity> listAddress = repository.getAllAddress();
        assertThat(listAddress.size()).isEqualTo(2);

        AddressEntity address1 = listAddress.get(0);
        AddressEntity address2 = listAddress.get(1);

        assertThat(address1.getStreet()).isEqualTo("Teodoro Machado");
        assertThat(address1.getNumber()).isEqualTo(20);
        assertThat(address1.getBoroughs()).isEqualTo("Centro");
        assertThat(address1.getCity()).isEqualTo("Maringá");
        assertThat(address1.getState()).isEqualTo("Paraná");

        assertThat(address2.getStreet()).isEqualTo("Barão");
        assertThat(address2.getNumber()).isEqualTo(200);
        assertThat(address2.getBoroughs()).isEqualTo("Mandacaru");
        assertThat(address2.getCity()).isEqualTo("Londrina");
        assertThat(address2.getState()).isEqualTo("Paraná");
    }

    @Test
    void delete() {
        repository.saveAddress("Martins", 20, "Centro", "Maringá", "Paraná");

        List<AddressEntity> listAddress = repository.getAllAddress();

        assertThat(listAddress.size()).isEqualTo(1);

        repository.deleteAddress(1);

        List<AddressEntity> listAddress2 = repository.getAllAddress();

        assertThat(listAddress2.size()).isEqualTo(0);
    }
}
