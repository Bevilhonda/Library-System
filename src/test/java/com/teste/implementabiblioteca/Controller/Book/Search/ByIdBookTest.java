package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Controller.Book.Search.ById.ByIdBook;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ByIdBook.class)
class ByIdBookTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook services;

    @Test
    void getBookById() throws BookNotFound, Exception {
        LocalDate datePublication = LocalDate.parse("1968-01-01");
        BookEntity book = new BookEntity(
                "Java",datePublication,1,1,1,1);
        when(services.getById(1)).thenReturn(book);

        mockMvc.perform(get("/Book/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name.fullName").value("Java"))
                .andReturn();
    }
    @Test
    void requestValidationNotCompleted() throws Exception, BookNotFound {

        when(services.getById(1)).thenThrow(new BookNotFound(1));

        mockMvc.perform(get("/Book/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

        verify(services,times(1)).getById(1);
    }
}