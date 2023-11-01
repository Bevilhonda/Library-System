package com.teste.implementabiblioteca.Services;


import com.teste.implementabiblioteca.Model.Library.Exceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.RegisterLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DataJpaTest
@ComponentScan()
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class TestServicesLibrary {
    @Autowired
    private ServicesLibrary services;

    @Test
    void insert() throws ErrorSavingLibrary {
        LibraryEntity library = new LibraryEntity(null, "Maringá", 1);

        services.insert(library);

        assertThat(library.getName()).isEqualTo("Maringá");
        assertThat(library.getFkAddress()).isEqualTo(1);
    }
    @Test
    void update() throws ErrorSavingLibrary, LibraryNotFound, RegisterLibraryNotFound {
        LibraryEntity library = new LibraryEntity(null, "Maringá", 1);
        LibraryEntity library1 = new LibraryEntity(null, "Londrina", 2);

        services.insert(library);

        services.update(1,library1);
        List<LibraryEntity> list = services.getAllLibrary();

        assertThat(list.get(0).getName()).isEqualTo(library1.getName());
        assertThat(list.get(0).getFkAddress()).isEqualTo(library1.getFkAddress());
    }
    @Test
    void getById() throws ErrorSavingLibrary, LibraryNotFound {
        LibraryEntity library = new LibraryEntity(null, "Maringá", 1);

        services.insert(library);

        LibraryEntity libraryActual = services.getById(1);

        assertThat(libraryActual.getIdLibrary()).isEqualTo(1);
        assertThat(libraryActual.getName()).isEqualTo(library.getName());
        assertThat(libraryActual.getFkAddress()).isEqualTo(library.getFkAddress());
    }
    @Test
    void getAllLibrarys() throws ErrorSavingLibrary, RegisterLibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null, "Maringá", 1);
        LibraryEntity library2 = new LibraryEntity(null, "Londrina", 2);

        services.insert(library1);
        services.insert(library2);

        List<LibraryEntity> list = services.getAllLibrary();
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getIdLibrary()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo(library1.getName());
        assertThat(list.get(0).getFkAddress()).isEqualTo(library1.getFkAddress());
    }
    @Test
    void getByName() throws ErrorSavingLibrary, NameLibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null, "Maringá", 1);
        LibraryEntity library2 = new LibraryEntity(null, "Londrina", 2);
        LibraryEntity library3 = new LibraryEntity(null, "Maringá", 3);

        services.insert(library1);
        services.insert(library2);
        services.insert(library3);

        List<LibraryEntity> list = services.getLibraryByName("Maringá");
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getIdLibrary()).isEqualTo(1);
        assertThat(list.get(0).getName()).isEqualTo(library1.getName());
        assertThat(list.get(0).getFkAddress()).isEqualTo(library1.getFkAddress());

        assertThat(list.get(1).getIdLibrary()).isEqualTo(3);
        assertThat(list.get(1).getName()).isEqualTo(library3.getName());
        assertThat(list.get(1).getFkAddress()).isEqualTo(library3.getFkAddress());
    }

    @Test
    void delete() throws ErrorSavingLibrary, RegisterLibraryNotFound, LibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null, "Maringá", 1);
        LibraryEntity library2 = new LibraryEntity(null, "Londrina", 2);

        services.insert(library1);
        services.insert(library2);

        List<LibraryEntity> list = services.getAllLibrary();
        assertThat(list.size()).isEqualTo(2);

        services.delete(1);

        List<LibraryEntity> list2 = services.getAllLibrary();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(list2.get(0).getIdLibrary()).isEqualTo(2);
        assertThat(list2.get(0).getName()).isEqualTo(library2.getName());
        assertThat(list2.get(0).getFkAddress()).isEqualTo(library2.getFkAddress());
    }

    @Test
    void exceptionLibraryNotFound(){
        Throwable exception = catchThrowable(() -> {
            services.getById(1);
        });

        assertThat(exception)
                .isInstanceOf(LibraryNotFound.class)
                .hasMessageContaining("A Biblioteca com o id 1 não  foi encontrada.");
    }

    @Test
    void exceptionNameLibraryNotFound(){
        Throwable exception = catchThrowable(() -> {
            services.getLibraryByName("Maringá");
        });

        assertThat(exception)
                .isInstanceOf(NameLibraryNotFound.class)
                .hasMessageContaining("A Biblioteca com o nome Maringá não  foi encontrada.");
    }

    @Test
    void exceptionRegisterLibraryNotFound() {

        Throwable exception = catchThrowable(() -> {
            services.getAllLibrary();

        });

        assertThat(exception)
                .isInstanceOf(RegisterLibraryNotFound.class)
                .hasMessageContaining("Nenhuma Biblioteca foi cadastrada.");
    }
}
