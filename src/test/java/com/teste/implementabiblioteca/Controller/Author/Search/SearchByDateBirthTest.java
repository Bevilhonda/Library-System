package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.Search.BetweenYears.SearchByDateBirth;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchByDateBirth.class)
class SearchByDateBirthTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor services;

    @Test
    void byDateBirth() throws DateBirthNotFound, Exception {
        LocalDate dateBirth1 = LocalDate.parse("1989-01-01");
        LocalDate dateBirth2 = LocalDate.parse("1999-01-01");
        AuthorEntity author1 = new AuthorEntity(null, "Jorge", "Pereira", dateBirth1);
        AuthorEntity author2 = new AuthorEntity(null, "Lucas", "Carvalho", dateBirth2);

        List<AuthorEntity> list = new ArrayList<>();
        list.add(author1);
        list.add(author2);

        when(services.getByDateBirth("1989-01-01", "1999-01-01")).thenReturn(list);
        this.mockMvc.perform(get("/Autor/DateBirth/1989-01-01/1999-01-01"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.list[0].nameLastname.fullname").value("Jorge"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.list[0].data_nascimento").value("1989-01-01"))
                .andReturn();
    }
}