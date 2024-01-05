package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Controller.Library.Search.ById.ByIdLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ByIdLibrary.class)
class ByIdLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;


    @Test
    void getLibraryById() throws LibraryNotFound, Exception {
        LibraryEntity library = new LibraryEntity(1, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");

        when(services.getById(1)).thenReturn(library);
        this.mockMvc.perform(get("/Library/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Maringá"))
                .andReturn();
    }
    @Test
    void requestValidationNotCompleted() throws LibraryNotFound, Exception {

        when(services.getById(1))
                .thenThrow(new LibraryNotFound(1));

        mockMvc.perform(get("/Library/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }
}