package com.teste.implementabiblioteca.Controller.Author.Delete;

import com.teste.implementabiblioteca.Model.Author.Exceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
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
@WebMvcTest(DeleteAuthor.class)
class DeleteAuthorTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor service;

    @Test
    void deleteAuthor() throws Exception, AuthorNotFound {

        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteAuthor/{id}", 1))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(service).delete(1);// Verifica se o metodo delete foi chamado com o ID certo

        Mockito.verify(service, times(1)).delete(1);
        // Verifica se o metodo foi chamado apenas uma vez

    }
    @Test
    void requestValidationNotCompleted() throws AuthorNotFound, Exception {
        doThrow(new AuthorNotFound(1))
                .when(service).delete(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteAuthor/{id}",1))
                .andExpect(status().isNotFound())
                .andReturn();
        verify(service,times(1)).delete(1);

    }
}