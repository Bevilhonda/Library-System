package com.teste.implementabiblioteca.Services.Library;


import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.RegisterLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesLibrary {

    @Autowired
    private RepositoryLibrary repository;
    @Autowired
    private RepositoryAddress repositoryAddress;

    public LibraryEntity getById(Integer id) throws LibraryNotFound {

        LibraryEntity library = repository.getLibraryById(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        return library;
    }

    public List<LibraryEntity> getLibraryByName(String nome) throws NameLibraryNotFound {

        List<LibraryEntity> listNames = repository.getLibraryByName(nome);

        if (listNames.isEmpty()) {
            throw new NameLibraryNotFound(nome);
        }
        return listNames;
    }

    public List<LibraryEntity> getAllLibrary() throws RegisterLibraryNotFound {

        List<LibraryEntity> list = repository.getAllLibrary();

        if (list.isEmpty()) {
            throw new RegisterLibraryNotFound();
        }
        return list;
    }

    public List<AuthorEntity> getAllAuthorsByNameLibrary(String nome) throws NameLibraryNotFound {

        List<AuthorEntity> listAuthors = repository.getListAuthorsInTheLibrary(nome);
        if (listAuthors.isEmpty()) {
            throw new NameLibraryNotFound(nome);
        }

        return listAuthors;
    }

    public void insert(LibraryEntity library) {

        repository.saveLibrary(library.getNome(), library.getRua(), library.getNumero(),
                library.getBairro(), library.getCidade(), library.getEstado());
    }

    public void update(Integer id, LibraryEntity library) throws LibraryNotFound {
        LibraryEntity dataLibrary = repository.getLibraryById(id);
        if (dataLibrary == null) {
            throw new LibraryNotFound(id);
        }
        repository.update(library.getNome(), library.getRua(), library.getNumero(),
                library.getBairro(), library.getCidade(), library.getEstado(), id);
    }

    public void delete(Integer id) throws LibraryNotFound {
        LibraryEntity library = repository.getLibraryById(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        repository.delete(id);
    }
}
