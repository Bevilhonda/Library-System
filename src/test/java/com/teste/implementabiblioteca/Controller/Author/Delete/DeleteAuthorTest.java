package com.teste.implementabiblioteca.Controller.Author.Delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static java.time.LocalDate.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeleteAuthor.class)
class DeleteAuthorTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deleteAuthor() throws Exception {
        LocalDate dateBirth = parse("1995-05-03");
        AuthorEntity author = new AuthorEntity(1,"João","Gomes",dateBirth);

        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteAuthor/{id}",1))
                .andExpect(status().isAccepted());

    }
}