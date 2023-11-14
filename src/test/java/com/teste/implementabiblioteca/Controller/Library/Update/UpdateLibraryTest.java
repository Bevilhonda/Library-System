package com.teste.implementabiblioteca.Controller.Library.Update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Library.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateLibrary.class)
class UpdateLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void update() throws Exception, LibraryNotFound {
        RequestData request = new RequestData(1, "Maringá", 2);

        this.mockMvc.perform(put("/UpdateLibrary/{id}", 1)
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        ArgumentCaptor<LibraryEntity> libraryCaptor = ArgumentCaptor.forClass(LibraryEntity.class);

        verify(services, times(1)).update(eq(1), libraryCaptor.capture());
        assertThat(libraryCaptor.getValue().getName()).isEqualTo("Maringá");
    }

    @Test
    void requestValidationUpgradeNotCompleted() throws LibraryNotFound, Exception {
        RequestData request = new RequestData(1, "Maringá", 2);

        doThrow(new LibraryNotFound(1))
                .when(services).update(any(), any());

        mockMvc.perform(put("/UpdateLibrary/{id}", 1)
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .string("A Biblioteca com o id " + request.getId_biblioteca() +
                                " não  foi encontrada."))
                .andReturn();
    }

    @Test
    void validationMissingParameterName() throws Exception, LibraryNotFound {
        RequestData request = new RequestData(1, null, 2);

        this.mockMvc.perform(put("/UpdateLibrary/{id}", 1)
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Nome' é obrigatório.\"]"));

        verify(services, never()).update(eq(1), any(LibraryEntity.class));
    }

    @Test
    void validationMissingParameterIdAddress() throws Exception, LibraryNotFound {
        RequestData request = new RequestData(1, "Maringá", null);

        this.mockMvc.perform(put("/UpdateLibrary/{id}", 1)
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número do Id de endereço é obrigatório.\"]"));

        verify(services, never()).update(eq(1), any(LibraryEntity.class));
    }

}