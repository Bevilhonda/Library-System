package com.teste.implementabiblioteca.Controller.Book.Insert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Book.Insert.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Insert.class)
class InsertTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void insert() throws Exception {
        LocalDate dataPublication = LocalDate.parse("1990-12-12");
        RequestData request = new RequestData(
                "Css",
                dataPublication,
                1,
                1,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<BookEntity> bookCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(services, times(1)).insert(bookCaptor.capture());

        assertThat(bookCaptor.getValue().getTitle()).isEqualTo("Css");

    }

    @Test
    void validationMissingParameterTitle() throws Exception {
        LocalDate dataPublication = LocalDate.parse("1990-12-12");
        RequestData request = new RequestData(
                null,
                dataPublication,
                1,
                1,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Titulo' é obrigatório.\"]"));

        verify(services, never()).insert(any(BookEntity.class));

    }
    @Test
    void validationMissingParameterDatePublication() throws Exception {

        RequestData request = new RequestData(
                "Java",
                null,
                1,
                1,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"A data de publicação é obrigatório.\"]"));

        verify(services, never()).insert(any(BookEntity.class));
    }
    @Test
    void validationMissingParameterEdition() throws Exception {
        LocalDate datePublication = LocalDate.parse("2000-12-12");
        RequestData request = new RequestData(
                "Java",
                datePublication,
                null,
                1,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número da edição é obrigatório.\"]"));

        verify(services,never()).insert(any(BookEntity.class));
    }
    @Test
    void validationMissingParameterIdLibrary() throws Exception {
        LocalDate datePublication = LocalDate.parse("1995-12-25");
        RequestData request = new RequestData(
                "Html",
                datePublication,
                1,
                null,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número do Id de biblioteca é obrigatório.\"]"));
        verify(services,never()).insert(any(BookEntity.class));
    }
    @Test
    void validationMissingParameterIdAuthor() throws Exception {
        LocalDate datePublication = LocalDate.parse("1995-12-25");
        RequestData request = new RequestData(
                "Html",
                null,
                1,
                1,
                1,
                1);

        this.mockMvc.perform(post("/Insert/Book")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O número do Id de autor é obrigatório.\"]"));
        verify(services,never()).insert(any(BookEntity.class));
    }
}