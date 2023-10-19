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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ComponentScan()
public class TestDelete {
    @Autowired
    RepositoryAddress repository;

    @Test
    void delete() {
        Integer address1 = repository.saveAddress
                (
                        "Martins",
                        20,
                        "Centro",
                        "Maringá",
                        "Paraná"
                );
        Integer address2 = repository.saveAddress
                (
                        "Barão",
                        20,
                        "Zona sul",
                        "Londrina",
                        "Paraná"
                );
        List<AddressEntity> listAddress = repository.getAllAddress();
        assertThat(listAddress).isNotNull();
        assertThat(listAddress.size()).isEqualTo(2);

        Integer deleteAddress = repository.deleteAddress(1);

        List<AddressEntity> listAddress2 = repository.getAllAddress();
        assertThat(listAddress2.size()).isEqualTo(1);

        System.out.println(listAddress2.get(0).getStreet());

    }
}
