package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Controller.Library.Search.ByName.ByName;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ByName.class)
class ByNameTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;

    @Test
    void getNameLibrary() throws NameLibraryNotFound, Exception {
        LibraryEntity library1 = new LibraryEntity(1, "Curitiba","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library2 = new LibraryEntity(1, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");
        List<LibraryEntity> list = new ArrayList<>();
        list.add(library1);
        list.add(library2);

        when(services.getLibraryByName("Curitiba")).thenReturn(list);
        this.mockMvc.perform(get("/Library/Name/Curitiba"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].nome").value("Curitiba"))
                .andReturn();
    }
    @Test
    void requestValidationNotCompleted() throws NameLibraryNotFound, Exception {
        List<LibraryEntity> listEmpty = new ArrayList<>();

        when(services.getLibraryByName("Maringá"))
                .thenThrow(new NameLibraryNotFound("Maringá"))
                .thenReturn(listEmpty);

        mockMvc.perform(get("/Library/Name/Maringá"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }
}