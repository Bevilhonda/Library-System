package com.teste.implementabiblioteca.Services.Library.ClassServices;

import com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;
import static com.teste.implementabiblioteca.Controller.Library.FormatterResponse.HelperResponseLibrary.DetailsAllLibrary;

@Service
public class ByName {
    @Autowired
    private RepositoryLibrary repositorylibrary;
    public ResponseEntity<?> GetLibraryByName(String nome) {
        try {
            List<LibraryEntity> name = repositorylibrary.GetAllName(nome);
            if (name.isEmpty()) {
                throw new NameLibraryNotFound(nome);
            }
            return DetailsAllLibrary(name, HttpStatus.OK);
        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }
    }
}
