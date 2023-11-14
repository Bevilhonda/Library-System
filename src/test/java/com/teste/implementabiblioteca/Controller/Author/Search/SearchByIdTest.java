package com.teste.implementabiblioteca.Controller.Author.Search;

import com.teste.implementabiblioteca.Controller.Author.Search.ById.SearchById;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Author.Exceptions.AuthorNotFound;

import com.teste.implementabiblioteca.Services.Author.ServicesAuthor;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchById.class)
class SearchByIdTest {
    @Autowired
    private MockMvc mockMvc;// aqui está injetando o MockMvc
    @MockBean
    private ServicesAuthor services;// criando uma simulação do service
    // graças a notação @MockBean

    @Test
    void searchById() throws Exception, AuthorNotFound {

        LocalDate dateBirth = LocalDate.parse("2018-10-15");
        AuthorEntity author = new AuthorEntity(null, "Pedro", "Santos", dateBirth);

        when(services.getById(1)).thenReturn(author);// when é do mock , e quando acessa a função getById(1) , retorna o autor
        this.mockMvc.perform(get("/Author/1"))// aqui esta simulando uma solicitação igual no postman
                .andExpect(MockMvcResultMatchers.status().isOk())// verifica se o status da resposta é 200 (ok)
                // daqui para baixo verifica se os campos são os mesmos do autor instanciado , como se fosse os asserts
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome.name").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome.lastName").value("Santos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data_nascimento").value("2018-10-15"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();//aqui encerra o teste e obtem o resultado do teste.
    }
    @Test
    void requestValidationNotCompleted() throws AuthorNotFound, Exception {

        when(services.getById(1)).thenThrow(new AuthorNotFound(1)); // thenThrow = Então lance

        mockMvc.perform(get("/Author/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }
}