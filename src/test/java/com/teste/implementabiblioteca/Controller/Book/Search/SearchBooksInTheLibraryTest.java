package com.teste.implementabiblioteca.Controller.Book.Search;

import com.teste.implementabiblioteca.Controller.Book.Search.BooksInTheLibrary.SearchBooksInTheLibrary;
import com.teste.implementabiblioteca.Model.Book.BookEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Services.Book.ServicesBook;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchBooksInTheLibrary.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SearchBooksInTheLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesBook servicesBook;

    @Test
    void getBooksInTheLibrary() throws Exception, LibraryNotFound {
        LocalDate dataPublication = LocalDate.parse("2018-10-15");
        BookEntity book = new BookEntity("Java", dataPublication, 1, 1,
                1, 1);

        List<BookEntity> listBooks = new ArrayList<>();
        listBooks.add(book);

        when(servicesBook.getBooksByNameLibrary(1)).thenReturn(listBooks);
        this.mockMvc.perform(get("/SearchBooks/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[0].title")
                        .value("Java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[0].data_publication")
                        .value("2018-10-15"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[0].edicao")
                        .value("1"))
                .andReturn();

    }
    @Test
    void requestValidationNotCompleted()throws Exception, LibraryNotFound{
        List<BookEntity> listEmpty = new ArrayList<>();

        when(servicesBook.getBooksByNameLibrary(1))
                .thenThrow(new LibraryNotFound(1))
                .thenReturn(listEmpty);
        mockMvc.perform(get("/SearchBooks/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

    }
}