package com.teste.implementabiblioteca.Controller.Author.Update;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Author.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateAuthor.class)
class UpdateAuthorTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicesAuthor service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateTest() throws Exception, AuthorNotFound {

        LocalDate dateBirth = LocalDate.parse("2000-02-15");
        RequestData requestAuthor = new RequestData(1, "Jorge", "Santos", dateBirth);

        mockMvc.perform(put("/UpdateAuthor/{id}", 1)
                .content(objectMapper.writeValueAsString(requestAuthor))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();

        ArgumentCaptor<AuthorEntity> authorCaptor = ArgumentCaptor.forClass(AuthorEntity.class);
        verify(service, times(1)).updateAuthor(eq(1), authorCaptor.capture());

        assertThat(authorCaptor.getValue().getName()).isEqualTo("Jorge");

    }

    @Test
    public void test() throws Exception, AuthorNotFound {
        LocalDate dateBirth = LocalDate.parse("2000-02-15");
        RequestData requestAuthor = new RequestData(4, "Jorge", "Santos", dateBirth);

        doThrow(new AuthorNotFound(4))
            .when(service)
            .updateAuthor(any(), any());

        mockMvc.perform(put("/UpdateAuthor/{id}", requestAuthor.getIdAuthor())
                .content(objectMapper.writeValueAsString(requestAuthor))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(content().string("O Autor com o id " + requestAuthor.getIdAuthor() + " não  foi encontrado."))
            .andReturn();
    }

    @Test
    public void validationMissingParametersName() throws Exception, AuthorNotFound {

        LocalDate dateBirth = LocalDate.parse("2000-02-15");
        RequestData requestAuthor = new RequestData(1, null, "Santos", dateBirth);

        mockMvc.perform(put("/UpdateAuthor/{id}", 1)
                .content(objectMapper.writeValueAsString(requestAuthor))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(content().json("[\"O campo 'Nome' é obrigatório.\"]"));

        verify(service, never()).updateAuthor(eq(1), any(AuthorEntity.class));
        //verifica se o método service.updateAuthor não foi chamado em nenhum momento
        // durante o teste. O método never() é usado para indicar que o
        // método não deve ser chamado em nenhuma situação.
    }
    @Test
    public void validationMissingParametersLastName() throws Exception, AuthorNotFound {

        LocalDate dateBirth = LocalDate.parse("2000-02-15");
        RequestData requestAuthor = new RequestData(1, "Jorge", null, dateBirth);

        mockMvc.perform(put("/UpdateAuthor/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestAuthor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Sobrenome' é obrigatório.\"]"));

        verify(service, never()).updateAuthor(eq(1), any(AuthorEntity.class));

    }
    @Test
    public void validationMissingParametersDateBirth() throws Exception, AuthorNotFound {

        LocalDate dateBirth = LocalDate.parse("2000-02-15");
        RequestData requestAuthor = new RequestData(1, "Jorge", "Santos", null);

        mockMvc.perform(put("/UpdateAuthor/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestAuthor))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Data de Nascimento' é obrigatório.\"]"));

        verify(service, never()).updateAuthor(eq(1), any(AuthorEntity.class));

    }
}