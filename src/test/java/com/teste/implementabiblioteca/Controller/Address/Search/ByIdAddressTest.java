package com.teste.implementabiblioteca.Controller.Address.Search;

import com.teste.implementabiblioteca.Controller.Address.Search.ById.ByIdAddress;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ByIdAddress.class)
class ByIdAddressTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAddress services;

    @Test
    void getAddressById() throws AddressNotFound, Exception {
        AddressEntity address = new AddressEntity(
                1, "Teodoro", 30, "Londrina", "Centro", "Paraná");

        when(services.getById(1)).thenReturn(address);
        this.mockMvc.perform(get("/Address/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.fullAddress.street").value("Teodoro"))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.fullAddress.number").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.fullAddress.boroughs").value("Centro"))
                .andReturn();
    }
    @Test
    void getAddressById_AddressNotFound() throws AddressNotFound, Exception {
        when(services.getById(1)).thenThrow(new AddressNotFound(1));

        this.mockMvc.perform(get("/Address/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }
}