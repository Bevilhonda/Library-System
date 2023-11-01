package com.teste.implementabiblioteca.Services;


import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.Exceptions.RegisterAddressNotFound;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestServicesAddress {
    @Autowired
    ServicesAddress services;
    @Test
    void getById() throws AddressNotFound {
        AddressEntity address = new AddressEntity
                (null, "Teodoro Machado", 20, "Maringá", "Centro", "Paraná");

        services.insertAddress(address);

        AddressEntity addressActual = services.getById(1);

        assertThat(addressActual.getStreet()).isEqualTo(address.getStreet());
        assertThat(addressActual.getNumber()).isEqualTo(address.getNumber());
        assertThat(addressActual.getBoroughs()).isEqualTo(address.getBoroughs());
        assertThat(addressActual.getCity()).isEqualTo(address.getCity());
        assertThat(addressActual.getState()).isEqualTo(address.getState());
    }

    @Test
    void getAllAddress() throws RegisterAddressNotFound {
        AddressEntity address = new AddressEntity
                (1, "Teodoro Machado", 20, "Maringá", "Centro", "Paraná");
        AddressEntity address2 = new AddressEntity
                (2, "Lucas Machado", 200, "Centro Sul", "Londrina", "Paraná");

        services.insertAddress(address);
        services.insertAddress(address2);

        List<AddressEntity> list = services.getAllAddress();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0).getIdAddress()).isEqualTo(address.getIdAddress());
        assertThat(list.get(0).getStreet()).isEqualTo(address.getStreet());
        assertThat(list.get(0).getNumber()).isEqualTo(address.getNumber());
        assertThat(list.get(0).getBoroughs()).isEqualTo(address.getBoroughs());
        assertThat(list.get(0).getCity()).isEqualTo(address.getCity());
        assertThat(list.get(0).getState()).isEqualTo(address.getState());
    }

    @Test
    void insert() throws  AddressNotFound {
        AddressEntity address = new AddressEntity
                (null, "Teodoro Machado", 20, "Maringá", "Centro", "Paraná");

        services.insertAddress(address);

        AddressEntity addressActual = services.getById(1);

        assertThat(addressActual.getStreet()).isEqualTo(address.getStreet());
        assertThat(addressActual.getNumber()).isEqualTo(address.getNumber());
        assertThat(addressActual.getBoroughs()).isEqualTo(address.getBoroughs());
        assertThat(addressActual.getCity()).isEqualTo(address.getCity());
        assertThat(addressActual.getState()).isEqualTo(address.getState());
    }

    @Test
    void update() throws AddressNotFound, RegisterAddressNotFound {
        AddressEntity address1 = new AddressEntity
                (null, "Teodoro", 20, "Maringá", "Centro", "Paraná");
        AddressEntity address2 = new AddressEntity
                (null, "Lucas", 200, "Londrina", "Centro Sul", "Paraná");

        services.insertAddress(address1);
        assertThat(address1.getStreet()).isEqualTo("Teodoro");

        services.updateAddress(1, address2);

        List<AddressEntity> list = services.getAllAddress();
        assertThat(list.size()).isEqualTo(1);

        assertThat(list.get(0).getIdAddress()).isEqualTo(1);
        assertThat(list.get(0).getStreet()).isEqualTo(address2.getStreet());
        assertThat(list.get(0).getNumber()).isEqualTo(address2.getNumber());
        assertThat(list.get(0).getBoroughs()).isEqualTo(address2.getBoroughs());
        assertThat(list.get(0).getCity()).isEqualTo(address2.getCity());
        assertThat(list.get(0).getState()).isEqualTo(address2.getState());
    }

    @Test
    void delete() throws AddressNotFound, RegisterAddressNotFound {
        AddressEntity addressMaringa = new AddressEntity
                (null, "Teodoro", 20, "Maringá", "Centro", "Paraná");
        AddressEntity addressLondrina = new AddressEntity
                (null, "Lucas", 200, "Londrina", "Centro Sul", "Paraná");

        services.insertAddress(addressMaringa);
        services.insertAddress(addressLondrina);

        List<AddressEntity> list = services.getAllAddress();
        assertThat(list.size()).isEqualTo(2);

        services.deleteAddress(1);
        AddressEntity addressActual = services.getById(2);

        List<AddressEntity> list2 = services.getAllAddress();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(list2.get(0).getIdAddress()).isEqualTo(addressActual.getIdAddress());
        assertThat(list2.get(0).getStreet()).isEqualTo(addressActual.getStreet());
        assertThat(list2.get(0).getNumber()).isEqualTo(addressActual.getNumber());
        assertThat(list2.get(0).getBoroughs()).isEqualTo(addressActual.getBoroughs());
        assertThat(list2.get(0).getCity()).isEqualTo(addressActual.getCity());
        assertThat(list2.get(0).getState()).isEqualTo(addressActual.getState());
    }

    @Test
    void exceptionAddressNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getById(2);
        });

        assertThat(exception)
                .isInstanceOf(AddressNotFound.class)
                .hasMessageContaining("O endereço com o id 2 não foi encontrado.");
    }
    @Test
    void exceptionRegisterAddressNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getAllAddress();
        });

        assertThat(exception)
                .isInstanceOf(RegisterAddressNotFound.class)
                .hasMessageContaining("Nenhum endereço foi cadastrado.");
    }
}

