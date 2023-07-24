package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.MonitorExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapLibrary;
import static com.teste.implementabiblioteca.Services.HelperResponseLibrary.DetailsAllLibrary;
import static com.teste.implementabiblioteca.Services.HelperResponseLibrary.DetailsLibrary;

@Service
public class Library {

    @Autowired
    private RepositoryLibrary repositorylibrary;

    public ResponseEntity<?> GetLibraryById(Integer id) {
        try {

            LibraryEntity library = repositorylibrary.GetLibrary(id);

            if (library == null) {
                throw new LibraryNotFound(id);
            }
            return DetailsLibrary("id: " + library.getId_biblioteca() + "\n Nome: " +
                    library.getNome() + "\n Endereço: " + library.getFk_endereco(),
                     HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }

    public ResponseEntity<?> GetLibraryByName(String nome){
        try {
            List<LibraryEntity> name = repositorylibrary.GetName(nome);
            if (name.isEmpty()){
                throw new NameLibraryNotFound(nome);
            }
            return DetailsAllLibrary(name,HttpStatus.OK);
        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }

    public ResponseEntity<?> GetNameAndAddress(String nome){
        try {
            List<LibraryEntity> name = repositorylibrary.GetLibraryByName(nome);
            if (name.isEmpty()){
                throw new NameLibraryNotFound(nome);
            }
            return DetailsAllLibrary(name,HttpStatus.OK);
        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }
}
