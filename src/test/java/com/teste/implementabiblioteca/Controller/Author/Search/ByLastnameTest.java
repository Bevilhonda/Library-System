package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.Search.ByLastName.ByLastname;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.LastNameNotFound;
import com.teste.implementabiblioteca.Model.Author.Exceptions.RegisterNotFound;
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
@WebMvcTest(ByLastname.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ByLastnameTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor services;

    @Test
    void byLastName() throws Exception, LastNameNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author1 = new AuthorEntity(1, "Pedro", "Santos", dateBirth);
        AuthorEntity author2 = new AuthorEntity(2, "João", "Santos", dateBirth);

        List<AuthorEntity> list = new ArrayList<>();
        list.add(author1);
        list.add(author2);

        when(services.getByLastName("Santos")).thenReturn(list);
        this.mockMvc.perform(get("/Author/LastName/Santos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.list", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[0].name")
                        .value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[0].lastname.lastName")
                        .value("Santos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[1].name")
                        .value("João"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list[1].lastname.lastName")
                        .value("Santos"))
                .andReturn();
    }
    @Test
    void requestValidationNotCompleted() throws LastNameNotFound, Exception {
        List<AuthorEntity> listEmpty = new ArrayList<>();

        when(services.getByLastName("Santos"))
                .thenThrow(new LastNameNotFound("Santos"))
                .thenReturn(listEmpty);

        mockMvc.perform(get("/Author/LastName/Santos"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

    }
}