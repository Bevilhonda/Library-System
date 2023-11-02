package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.Search.AllAuthors.AllAuthors;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.RegisterNotFound;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(AllAuthors.class)
class AllAuthorsTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesAuthor services;

    @Test
    void allAuthors() throws Exception, RegisterNotFound {
        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author1 = new AuthorEntity(1, "Pedro", "Santos", dateBirth);
        AuthorEntity author2 = new AuthorEntity(2, "João", "Santos", dateBirth);

        List<AuthorEntity> list = new ArrayList<>();
        list.add(author1);
        list.add(author2);

        when(services.getAllAuthors()).thenReturn(list);
        this.mockMvc.perform(get("/Authors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseList[0].name.name")
                        .value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseList[0].name.lastName")
                        .value("Santos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.responseList[0].data_nascimento")
                        .value("2018-10-15"))
                .andReturn();
    }
    /* o modo como foi configurado a resposta de cada campo no Response , será o modo de como criar
    a pesquisa de cada campo , por exemplo :
    meu Json está configurado para aparecer desta forma:
    {
    "responseList": [
        {
            "id": 237,
            "name": {
                "name": "Theo Gawer ",
                "lastName": "Zanoni da Silva"
            },
            "data_nascimento": "1971-10-01"
        },
        SENDO ASSIM PARA ACESSAR CADA CAMPO FOI NESCESSÁRIO CRIAR NESTE FORMATO A PESQUISA :
        Para o nome : "$.responseList[0].name.name"
        Para sobrenome : "$.responseList[0].name.lastName"
        Para data de nascimento : "$.responseList[0].data_nascimento"

        MINHA CLASSE RESPONSE TEM RETORNO DE RESPONSELIST DE AUTORES

     */

}