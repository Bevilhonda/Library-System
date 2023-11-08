package com.teste.implementabiblioteca.Controller.Author.Insert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Author.Insert.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InsertAuthor.class)
public class InsertAuthorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicesAuthor service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testInsertAuthorEndpoint() throws Exception {
        LocalDate dateBirth = LocalDate.parse("1999-01-01");
        RequestData request = new RequestData("Jorge", "Batista", dateBirth);


        this.mockMvc.perform(post("/InsertAuthor")//simula uma solicitação para o endpoint "/InsertAuthor")
                        .content(objectMapper.writeValueAsString(request))//convert para
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<AuthorEntity> authorCaptor = ArgumentCaptor.forClass(AuthorEntity.class);
        verify(service, times(1)).insert(authorCaptor.capture());

        assertThat(authorCaptor.getValue().getIdAuthor()).isNull();
        assertThat(authorCaptor.getValue().getName()).isEqualTo("Jorge");
        assertThat(authorCaptor.getValue().getLastname()).isEqualTo("Batista");
        assertThat(authorCaptor.getValue().getDateBirth()).isEqualTo(dateBirth);

    }

    @Test
    void testExceptionInsert() throws Exception {
        LocalDate dateBirth = LocalDate.parse("1999-01-01");
        RequestData request = new RequestData(null, "Batista", dateBirth);

        this.mockMvc.perform(post("/InsertAuthor")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("[\"O campo 'Nome' é obrigatório.\"]"));
        verify(service, never()).insert(any(AuthorEntity.class));

    }
}
