package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Controller.Library.Search.AllLibrary.AllLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.RegisterLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.hamcrest.Matchers;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(AllLibrary.class)
class AllLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;

    @Test
    void getAllLibrary() throws RegisterLibraryNotFound, Exception {
        LibraryEntity library1 = new LibraryEntity(1, "Curitiba", 1);
        LibraryEntity library2 = new LibraryEntity(1, "Maringá", 1);
        List<LibraryEntity> list = new ArrayList<>();
        list.add(library1);
        list.add(library2);

        when(services.getAllLibrary()).thenReturn(list);
        this.mockMvc.perform(get("/Librarys"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.libraryList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.libraryList[0].name")
                        .value("Curitiba"))
                .andReturn();
    }
}