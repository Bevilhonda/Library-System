package com.teste.implementabiblioteca.Controller.Address.Insert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Address.Insert.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InsertAddress.class)
class InsertAddressTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAddress services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void insertAddress() throws Exception {

        RequestData request = new RequestData(
                1, "Vasco", 20, "Centro", "Maringá", "Paraná");

        this.mockMvc.perform(post("/Insert/Address")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<AddressEntity> addressCaptor = ArgumentCaptor.forClass(AddressEntity.class);
        verify(services, times(1)).insertAddress(addressCaptor.capture());

        assertThat(addressCaptor.getValue().getCity()).isEqualTo("Maringá");

    }
    @Test
    void validationMissingParametersStreet() throws Exception {

        RequestData request = new RequestData(
                1, null, 20, "Centro", "Maringá", "Paraná");

        this.mockMvc.perform(post("/Insert/Address")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Rua' é obrigatório.\"]"));

        verify(services, never()).insertAddress(any(AddressEntity.class));
    }

    @Test
    void validationMissingParametersNumber() throws Exception {

        RequestData request = new RequestData(
                1, "Vasco", null, "Centro", "Maringá", "Paraná");

        this.mockMvc.perform(post("/Insert/Address")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número da residência é obrigatório.\"]"));

        verify(services, never()).insertAddress(any(AddressEntity.class));
    }

    @Test
    void validationMissingParametersBoroughs() throws Exception {

        RequestData request = new RequestData(
                1, "Vasco", 20, null, "Maringá", "Paraná");

        this.mockMvc.perform(post("/Insert/Address")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'bairro' é obrigatório.\"]"));

        verify(services, never()).insertAddress(any(AddressEntity.class));
    }

    @Test
    void validationMissingParametersCity() throws Exception {

        RequestData request = new RequestData(
                1, "Vasco", 20, "Centro", null, "Paraná");

        this.mockMvc.perform(post("/Insert/Address")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'cidade' é obrigatório.\"]"));

        verify(services, never()).insertAddress(any(AddressEntity.class));
    }
}