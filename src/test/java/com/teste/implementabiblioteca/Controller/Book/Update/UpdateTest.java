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
                "Java",
                dataPublication,
                1,
                1);

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
    void requestValidationNotCompleted() throws BookNotFound, Exception {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Java",
                dataPublication,
                1,
                1);

        doThrow(new BookNotFound(1))
                .when(services).update(any(), any());

        mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content()
                        .string("O Livro com o id "
                                + requestData.getId_Livro() + " não  foi encontrado."))
                .andReturn();
    }

    @Test
    void validationMissingParameterIdAuthor() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Html",
                null,
                1,
                1);

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número do Id de autor é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1), any(BookEntity.class));

    }

    @Test
    void validationMissingParameterDatePublication() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Java",
                dataPublication,
                null,
                1);

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"A data de publicação é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1), any(BookEntity.class));

    }

    @Test
    void validationMissingParameterIdEdition() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Css",
                dataPublication,
                null,
                1
                );

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número da edição é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1), any(BookEntity.class));

    }

    @Test
    void validationMissingParameterIdLibrary() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                "Kotlin",
                dataPublication,
                1,
                null
                );

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número do Id de biblioteca é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1), any(BookEntity.class));

    }

    @Test
    void validationMissingParameterTitle() throws Exception, BookNotFound {
        LocalDate dataPublication = LocalDate.parse("1990-12-25");
        RequestData requestData = new RequestData(
                null,
                dataPublication,
                1,
                1
                );

        this.mockMvc.perform(put("/UpdateBook/{id}", 1)
                        .content(objectMapper.writeValueAsString(requestData))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Titulo' é obrigatório.\"]"))
                .andReturn();

        verify(services, never()).update(eq(1), any(BookEntity.class));

    }
}