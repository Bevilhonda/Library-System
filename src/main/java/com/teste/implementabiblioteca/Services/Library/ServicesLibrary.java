package com.teste.implementabiblioteca.Services.Library;


import com.teste.implementabiblioteca.Model.Library.TypeExceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.TypeExceptions.NameLibraryNotFound;
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
        Integer dataLibrary = repository.save(library.getName(),library.getFkAddress(),
                library.getIdLibrary());
        if (dataLibrary == null){
            throw new ErrorSavingLibrary();
        }

    }
    public void update(Integer id, LibraryEntity library) throws LibraryNotFound{
        LibraryEntity dataLibrary = repository.getLibrary(id);
        if (dataLibrary ==null){
            throw new LibraryNotFound(id);
        }
         repository.update(dataLibrary.getName(),dataLibrary.getFkAddress(),
                dataLibrary.getIdLibrary());
    }

    public void delete(Integer id) throws LibraryNotFound {
        LibraryEntity library = repository.getLibrary(id);
        if (library == null){
            throw new LibraryNotFound(id);
        }
        repository.delete(id);
    }
}
