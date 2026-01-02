package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.Search.AuthorsInTheLibrary.AllAuthorsRegisteredInTheLibrary;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(AllAuthorsRegisteredInTheLibrary.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AllAuthorsRegisteredInTheLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor services;

    @Test
    void getAuthorsInLibrarySelected() throws Exception, LibraryNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author1 = new AuthorEntity(1, "Pedro", "Santos", dateBirth);

        List<AuthorEntity> listAuthors = new ArrayList<>();
        listAuthors.add(author1);

        when(services.getAuthorsByNameLibrary(1)).thenReturn(listAuthors);
        this.mockMvc.perform(get("/SearchAuthors/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors[0].nome")
                        .value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authors[0].sobrenome")
                        .value("Santos"))
                .andReturn();


    }

    @Test
    void requestValidationNotCompleted() throws Exception, LibraryNotFound {
        List<AuthorEntity> listEmpty = new ArrayList<>();

        when(services.getAuthorsByNameLibrary(1))
                .thenThrow(new LibraryNotFound(1))
                .thenReturn(listEmpty);

        mockMvc.perform(get("/SearchAuthors/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

    }
}