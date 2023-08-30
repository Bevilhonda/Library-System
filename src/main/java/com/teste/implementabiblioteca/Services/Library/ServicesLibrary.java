package com.teste.implementabiblioteca.Services.Library;


import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesLibrary {
    @Autowired
    private RepositoryLibrary repository;

    public LibraryEntity getLibraryById(Integer id) throws LibraryNotFound {

        LibraryEntity library = repository.getLibrary(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        return library;
    }

    public List<LibraryEntity> getLibraryByName(String nome) throws NameLibraryNotFound {

        List<LibraryEntity> name = repository.getAllName(nome);

        if (name.isEmpty()) {
            throw new NameLibraryNotFound(nome);
        }
        return name;
    }

    public void insert(LibraryEntity library) throws ErrorSavingLibrary {
        Integer dataLibrary = repository.save(library.getName(), library.getFkAddress());
        if (dataLibrary == null) {
            throw new ErrorSavingLibrary();
        }

    }

    public void update(Integer id, LibraryEntity library) throws LibraryNotFound {
        LibraryEntity dataLibrary = repository.getLibrary(id);
        if (dataLibrary == null) {
            throw new LibraryNotFound(id);
        }
        repository.update(library.getName(), library.getFkAddress(), id);
    }

    public void delete(Integer id) throws LibraryNotFound {
        LibraryEntity library = repository.getLibrary(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        repository.deleteLibrary(id);
    }
}
