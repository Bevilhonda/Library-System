package com.teste.implementabiblioteca.Services;


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
    void insert() {
        LibraryEntity library = new LibraryEntity(null, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library);

        assertThat(library.getNome()).isEqualTo("Maringá");

    }

    @Test
    void update() throws LibraryNotFound, RegisterLibraryNotFound {
        LibraryEntity library = new LibraryEntity(null, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library1 = new LibraryEntity(null, "Londrina","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library);

        services.update(1, library1);
        List<LibraryEntity> list = services.getAllLibrary();

        assertThat(list.get(0).getNome()).isEqualTo(library1.getNome());

    }

    @Test
    void getById() throws LibraryNotFound {
        LibraryEntity library = new LibraryEntity(null, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library);

        LibraryEntity libraryActual = services.getById(1);

        assertThat(libraryActual.getId_biblioteca()).isEqualTo(1);
        assertThat(libraryActual.getNome()).isEqualTo(library.getNome());

    }

    @Test
    void getAllLibrarys() throws RegisterLibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library2 = new LibraryEntity(null,"Londrina","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library1);
        services.insert(library2);

        List<LibraryEntity> list = services.getAllLibrary();
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getId_biblioteca()).isEqualTo(1);
        assertThat(list.get(0).getNome()).isEqualTo(library1.getNome());

    }

    @Test
    void getByName() throws NameLibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null,"Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library2 = new LibraryEntity(null,"Londrina","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library3 = new LibraryEntity(null,"Londrina","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library1);
        services.insert(library2);
        services.insert(library3);

        List<LibraryEntity> list = services.getLibraryByName("Maringá");
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0).getId_biblioteca()).isEqualTo(1);
        assertThat(list.get(0).getNome()).isEqualTo(library1.getNome());


        assertThat(list.get(1).getId_biblioteca()).isEqualTo(3);
        assertThat(list.get(1).getNome()).isEqualTo(library3.getNome());

    }

    @Test
    void delete() throws RegisterLibraryNotFound, LibraryNotFound {
        LibraryEntity library1 = new LibraryEntity(null,"Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");
        LibraryEntity library2 = new LibraryEntity(null,"Londrina","Tabata",12,"Centro",
                "Maringá","Paraná");

        services.insert(library1);
        services.insert(library2);

        List<LibraryEntity> list = services.getAllLibrary();
        assertThat(list.size()).isEqualTo(2);

        services.delete(1);

        List<LibraryEntity> list2 = services.getAllLibrary();
        assertThat(list2.size()).isEqualTo(1);

        assertThat(list2.get(0).getId_biblioteca()).isEqualTo(2);
        assertThat(list2.get(0).getNome()).isEqualTo(library2.getNome());

    }

    @Test
    void exceptionLibraryNotFound() {
        Throwable exception = catchThrowable(() -> {
            services.getById(1);
        });

        assertThat(exception)
                .isInstanceOf(LibraryNotFound.class)
                .hasMessageContaining("A Biblioteca com o id 1 não  foi encontrada.");
    }

    @Test
    void exceptionNameLibraryNotFound() {
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

    @Test
    void exceptionUpdate() {
        Integer id = 20;
        LibraryEntity library = new LibraryEntity(1, "Maringá","Tabata",12,"Centro",
                "Maringá","Paraná");

        Throwable exception = catchThrowable(() -> {
            services.update(id, library);

        });

        assertThat(exception)
                .isInstanceOf(LibraryNotFound.class)
                .hasMessageContaining("A Biblioteca com o id 20 não  foi encontrada.");
    }

    @Test
    void exceptionDelete() {
        Integer id = 20;

        Throwable exception = catchThrowable(() -> {
            services.delete(id);

        });

        assertThat(exception)
                .isInstanceOf(LibraryNotFound.class)
                .hasMessageContaining("A Biblioteca com o id 20 não  foi encontrada.");
    }
}
