package com.teste.implementabiblioteca.Controller.Address.Update;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Address.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateAddress.class)
class UpdateAddressTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAddress services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateAddress() throws Exception, AddressNotFound {
        RequestData requestAddress = new RequestData(
                1, "Palmas", 12, "Maringá", "Centro", "Paraná");

        mockMvc.perform(put("/UpdateAddress/{id}",1)
                .content(objectMapper.writeValueAsBytes(requestAddress))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<AddressEntity> addressCaptor = ArgumentCaptor.forClass(AddressEntity.class);
        verify(services,times(1)).updateAddress(eq(1),addressCaptor.capture());

        assertThat(addressCaptor.getValue().getStreet()).isEqualTo("Palmas");
    }
    @Test
    void validationMissingParametersNumber() throws Exception, AddressNotFound {
        RequestData requestAddress = new RequestData(
                1, "Vasco", null, "Maringá", "Centro", "Paraná");

        mockMvc.perform(put("/UpdateAddress/{id}",1)
                        .content(objectMapper.writeValueAsBytes(requestAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número da residência é obrigatório.\"]"));

        verify(services,never()).updateAddress(eq(1),any(AddressEntity.class));
    }
    @Test
    void validationMissingParametersStreet() throws Exception, AddressNotFound {
        RequestData requestAddress = new RequestData(
                1, null, 12, "Maringá", "Centro", "Paraná");

        mockMvc.perform(put("/UpdateAddress/{id}",1)
                        .content(objectMapper.writeValueAsBytes(requestAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Rua' é obrigatório.\"]"));

        verify(services,never()).updateAddress(eq(1),any(AddressEntity.class));
    }
    @Test
    void validationMissingParametersCity() throws Exception, AddressNotFound {
        RequestData requestAddress = new RequestData(
                1, "Joaquin", 12, null, "Centro", "Paraná");

        mockMvc.perform(put("/UpdateAddress/{id}",1)
                        .content(objectMapper.writeValueAsBytes(requestAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'cidade' é obrigatório.\"]"));

        verify(services,never()).updateAddress(eq(1),any(AddressEntity.class));
    }
    @Test
    void validationMissingParametersBoroughs() throws Exception, AddressNotFound {
        RequestData requestAddress = new RequestData(
                1, "Lirios", 12, "Maringá", null, "Paraná");

        mockMvc.perform(put("/UpdateAddress/{id}",1)
                        .content(objectMapper.writeValueAsBytes(requestAddress))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'bairro' é obrigatório.\"]"));

        verify(services,never()).updateAddress(eq(1),any(AddressEntity.class));
    }
}