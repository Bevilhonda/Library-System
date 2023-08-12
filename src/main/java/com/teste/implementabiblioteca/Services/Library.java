package com.teste.implementabiblioteca.Services;


import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Controller.Library.MonittorExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Controller.Library.MonittorExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapLibrary;
import static com.teste.implementabiblioteca.Controller.Library.FormatterResponse.HelperResponseLibrary.DetailsAllLibrary;
import static com.teste.implementabiblioteca.Controller.Library.FormatterResponse.HelperResponseLibrary.DetailsLibrary;

@Service
public class Library {

    @Autowired
    private RepositoryLibrary repositorylibrary;

    public ResponseEntity<?> GetLibraryById(Integer id) {
        try {

            LibraryEntity library =repositorylibrary.GetLibrary(id);

            if (library == null) {
                throw new LibraryNotFound(id);
            }
            return DetailsLibrary("id: " + library.getIdLibrary() + "\n Nome: " +
                            library.getName() + "\n ID Endereço: " + library.getFkAddress(),
                    HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }

    public ResponseEntity<?> GetLibraryByName(String nome) {
        try {
            List<LibraryEntity> name = repositorylibrary.GetAllName(nome);
            if (name.isEmpty()) {
                throw new NameLibraryNotFound(nome);
            }
            return DetailsAllLibrary(name, HttpStatus.OK);
        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }
}
