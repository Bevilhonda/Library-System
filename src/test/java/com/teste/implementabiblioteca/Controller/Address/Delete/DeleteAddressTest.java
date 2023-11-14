package com.teste.implementabiblioteca.Controller.Address.Delete;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeleteAddress.class)
class DeleteAddressTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAddress services;

    @Test
    void deleteAddress() throws Exception, AddressNotFound {

        mockMvc.perform(MockMvcRequestBuilders.delete("/Delete/{id}", 1))
                .andExpect(status().isOk())
                .andReturn();

        verify(services).deleteAddress(1);

        verify(services, times(1)).deleteAddress(1);
    }

    @Test
    void requestValidationNotCompleted() throws Exception, AddressNotFound {

        doThrow(new AddressNotFound(4))
                .when(services).deleteAddress(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/Delete/{id}", 1))
                .andExpect(status().isNotFound())
                .andReturn();

        verify(services, times(1)).deleteAddress(1);
    }
}