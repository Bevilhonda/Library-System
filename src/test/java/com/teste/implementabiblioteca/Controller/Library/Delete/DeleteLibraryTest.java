package com.teste.implementabiblioteca.Controller.Library.Delete;

import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeleteLibrary.class)
class DeleteLibraryTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServicesLibrary services;


    @Test
    void delete() throws Exception, LibraryNotFound {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteLibrary/{id}",1))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(services).delete(1);
        Mockito.verify(services,Mockito.times(1)).delete(1);
    }
    @Test
    void requestValidationDeleteNotCompleted() throws LibraryNotFound, Exception {

        doThrow(new LibraryNotFound(1))
                .when(services).delete(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/DeleteLibrary/{id}",1))
                .andExpect(status().isNotFound())
                .andReturn();
        verify(services,times(1)).delete(1);

    }
}