package com.teste.implementabiblioteca.Services.Library;


import com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicesLibrary {
    @Autowired
    private RepositoryLibrary repositorylibrary;

    public LibraryEntity GetLibraryById(Integer id) throws LibraryNotFound {

        LibraryEntity library = repositorylibrary.GetLibrary(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        return library;
    }

    public List<LibraryEntity> GetLibraryByName(String nome) throws NameLibraryNotFound {

            List<LibraryEntity> name = repositorylibrary.GetAllName(nome);

            if (name.isEmpty()) {
                throw new NameLibraryNotFound(nome);
            }
            return name;
        }
}
