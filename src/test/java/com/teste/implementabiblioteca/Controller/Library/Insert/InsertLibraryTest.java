package com.teste.implementabiblioteca.Controller.Library.Insert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.implementabiblioteca.Controller.Library.Insert.DTO.RequestData;
import com.teste.implementabiblioteca.Model.Library.Exceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InsertLibrary.class)
class InsertLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void insert() throws Exception, ErrorSavingLibrary {
        RequestData request = new RequestData(
                1, "Londrina", 1);

        this.mockMvc.perform(post("/Insert")
                        .content(objectMapper.writeValueAsBytes(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ArgumentCaptor<LibraryEntity> libraryCaptor = ArgumentCaptor.forClass(LibraryEntity.class);
        verify(services, times(1)).insert(libraryCaptor.capture());
        assertThat(libraryCaptor.getValue().getName()).isEqualTo("Londrina");
    }
}