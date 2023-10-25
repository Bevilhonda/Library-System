package com.teste.implementabiblioteca.Services;


import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.Exceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Model.Address.Exceptions.RegisterAddressNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatObject;

@DataJpaTest
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestServicesAddress {
    @Autowired
    ServicesAddress services;
    @Autowired
    RepositoryAddress repository;

    @Test
    void getById() throws AddressNotFound {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");

        AddressEntity address = repository.getAddress(1);
        assertThat(address.getIdAddress()).isEqualTo(1);

        assertThat(services.getById(1).getStreet()).isEqualTo("Teodoro Machado");
        assertThat(services.getById(1).getNumber()).isEqualTo(20);
        assertThat(services.getById(1).getBoroughs()).isEqualTo("Centro");
        assertThat(services.getById(1).getCity()).isEqualTo("Maringá");
        assertThat(services.getById(1).getState()).isEqualTo("Paraná");
    }

    @Test
    void getAllAddress() throws RegisterAddressNotFound {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");
        repository.saveAddress("Lucas Machado", 200, "Centro Sul", "Londrina", "Paraná");

        assertThat(services.getAllAddress().size()).isEqualTo(2);
        assertThat(services.getAllAddress().get(0).getIdAddress()).isEqualTo(1);
        assertThat(services.getAllAddress().get(0).getStreet()).isEqualTo("Teodoro Machado");
        assertThat(services.getAllAddress().get(0).getNumber()).isEqualTo(20);
        assertThat(services.getAllAddress().get(0).getBoroughs()).isEqualTo("Centro");
        assertThat(services.getAllAddress().get(0).getCity()).isEqualTo("Maringá");
        assertThat(services.getAllAddress().get(0).getState()).isEqualTo("Paraná");
    }

    @Test
    void insert() throws ErrorSavingAddress {
        AddressEntity address = new AddressEntity
                (1, "Teodoro Machado", 20, "Maringá", "Centro", "Paraná");
        assertThat(address.getIdAddress()).isEqualTo(1);

        services.insertAddress(address);
        assertThat(address.getIdAddress()).isEqualTo(1);
        assertThat(address.getStreet()).isEqualTo("Teodoro Machado");
        assertThat(address.getNumber()).isEqualTo(20);
        assertThat(address.getBoroughs()).isEqualTo("Centro");
        assertThat(address.getCity()).isEqualTo("Maringá");
        assertThat(address.getState()).isEqualTo("Paraná");
    }

    @Test
    void update() throws AddressNotFound {

        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");
        repository.saveAddress("Lucas Machado", 200, "Centro Sul", "Londrina", "Paraná");

        AddressEntity address = repository.getAddress(1);
        AddressEntity address1 = repository.getAddress(2);

        services.updateAddress(2, address1);

        assertThat(address.getIdAddress()).isEqualTo(1);
        assertThat(address.getStreet()).isEqualTo("Teodoro Machado");
        assertThat(address.getNumber()).isEqualTo(20);
        assertThat(address.getBoroughs()).isEqualTo("Centro");
        assertThat(address.getCity()).isEqualTo("Maringá");
        assertThat(address.getState()).isEqualTo("Paraná");

        assertThat(address1.getIdAddress()).isEqualTo(2);
        assertThat(address1.getStreet()).isEqualTo("Lucas Machado");
        assertThat(address1.getNumber()).isEqualTo(200);
        assertThat(address1.getBoroughs()).isEqualTo("Centro Sul");
        assertThat(address1.getCity()).isEqualTo("Londrina");
        assertThat(address1.getState()).isEqualTo("Paraná");
    }

    @Test
    void delete() throws AddressNotFound {
        repository.saveAddress("Teodoro Machado", 20, "Centro", "Maringá", "Paraná");
        repository.saveAddress("Lucas Machado", 200, "Centro Sul", "Londrina", "Paraná");
        List<AddressEntity> list = repository.getAllAddress();
        assertThat(list.size()).isEqualTo(2);

        services.deleteAddress(1);
        AddressEntity address1 = repository.getAddress(2);

        List<AddressEntity> list2 = repository.getAllAddress();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(address1.getIdAddress()).isEqualTo(2);
        assertThat(address1.getStreet()).isEqualTo("Lucas Machado");
        assertThat(address1.getNumber()).isEqualTo(200);
        assertThat(address1.getBoroughs()).isEqualTo("Centro Sul");
        assertThat(address1.getCity()).isEqualTo("Londrina");
        assertThat(address1.getState()).isEqualTo("Paraná");
    }
}

