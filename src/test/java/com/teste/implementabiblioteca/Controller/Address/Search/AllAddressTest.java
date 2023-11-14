package com.teste.implementabiblioteca.Controller.Address.Search;

import com.teste.implementabiblioteca.Controller.Address.Search.AllAddress.AllAddress;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.RegisterAddressNotFound;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(AllAddress.class)
class AllAddressTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAddress services;

    @Test
    void getAllAuthors() throws RegisterAddressNotFound, Exception {
        AddressEntity address1 = new AddressEntity(
                1, "Havai", 35, "Maringá", "Centro", "Paraná");
        AddressEntity address2 = new AddressEntity(
                1, "Peres", 200, "Maringá", "Centro", "Paraná");
        List<AddressEntity> list = new ArrayList<>();
        list.add(address1);
        list.add(address2);

        when(services.getAllAddress()).thenReturn(list);

        mockMvc.perform(get("/Address"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.addressList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addressList[0].street")
                        .value("Havai"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.addressList[0].number")
                        .value(35))
                .andReturn();
    }

    @Test
    void validationMissingParametersAllAuthors() throws RegisterAddressNotFound, Exception {
        List<AddressEntity> listEmpty = new ArrayList<>();

        when(services.getAllAddress())
                .thenThrow(new RegisterAddressNotFound())
                .thenReturn(listEmpty);

        mockMvc.perform(get("/Address"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andReturn();
    }
}