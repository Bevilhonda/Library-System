package com.teste.implementabiblioteca.Model.Address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntityTest {

    @Test
    void AddressEntityTest(){
         AddressEntity address =
                 new AddressEntity(
                         1,
                         "Teodoro",
                         30,
                         "Maringá",
                         "Centro",
                         "Paraná"
                 );

         assertEquals(1,address.getIdAddress());
         assertEquals("Teodoro",address.getStreet());
         assertEquals(30 , address.getNumber());
         assertEquals("Maringá",address.getCity());
         assertEquals("Centro",address.getBoroughs());
         assertEquals("Paraná",address.getState());

    }

}