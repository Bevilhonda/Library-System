package com.teste.implementabiblioteca.Services.Library.ClassServices;

import com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;
import static com.teste.implementabiblioteca.Controller.Library.FormatterResponse.HelperResponseLibrary.DetailsLibrary;

@Service
public class ById {
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

        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }
    }
}
