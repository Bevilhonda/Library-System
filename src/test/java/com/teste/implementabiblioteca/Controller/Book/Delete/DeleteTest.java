package com.teste.implementabiblioteca.Controller.Book.Delete;

import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Delete.class)
class DeleteTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook services;

    @Test
    void delete() throws Exception, BookNotFound {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteBook/{id}",1))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(services).delete(1);

        Mockito.verify(services,Mockito.times(1)).delete(1);
    }
}