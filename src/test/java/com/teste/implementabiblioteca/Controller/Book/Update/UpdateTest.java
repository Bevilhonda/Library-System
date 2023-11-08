package com.teste.implementabiblioteca.Controller.Book.Update;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Book.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Update.class)
class UpdateTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void update() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Java", 1, dataPublication, 1, 1, 1);

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<BookEntity> bookCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(services, times(1)).update(eq(1), bookCaptor.capture());
        assertThat(bookCaptor.getValue().getTitle()).isEqualTo("Java");
    }
    @Test
    void validationException() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                null, 1, dataPublication, 1, 1, 1);

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Titulo' é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1),any(BookEntity.class));

    }
}