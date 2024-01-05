package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.AllBooks;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Book.Exceptions.RegisterBookNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(AllBooks.class)
class AllBooksTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook services;

    @Test
    void getAllBooks() throws RegisterBookNotFound, Exception {
        LocalDate datePublication1 = LocalDate.parse("1968-01-01");
        BookEntity book1 = new BookEntity(
                "Java",datePublication1,1,1,1,1);
        LocalDate datePublication2 = LocalDate.parse("1968-01-01");
        BookEntity book2 = new BookEntity(
                "Html",datePublication2,2,2,2,2);
        List<BookEntity> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);

        when(services.getAllBooks()).thenReturn(list);
        mockMvc.perform(get("/AllBooks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.books[0].book.title")
                        .value("Java"));

    }
    @Test
    void requestValidationNotCompleted() throws RegisterBookNotFound, Exception {
        List<BookEntity> listEmpty = new ArrayList<>();

        when(services.getAllBooks())
                .thenThrow(new RegisterBookNotFound());

        mockMvc.perform(get("/AllBooks"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
        verify(services,times(1)).getAllBooks();
    }
}