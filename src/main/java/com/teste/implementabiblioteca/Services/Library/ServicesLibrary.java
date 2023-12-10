package com.teste.implementabiblioteca.Services.Library;


import com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO.CompleteAddress;
import com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO.DataLibrarys;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.RegisterLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<LibraryEntity> getAllLibrary() throws RegisterLibraryNotFound{

        List<LibraryEntity> list = repository.getAllLibrary();

        if (list.isEmpty()){
            throw new RegisterLibraryNotFound();
        }
        return list;
    }
    public List<DataLibrarys> getAllLibraryAndAddress() throws RegisterLibraryNotFound{

        List<LibraryEntity> list = repository.getLibraryAndAddress();

        if (list.isEmpty()){
            throw new RegisterLibraryNotFound();
        }
        List<DataLibrarys> dataLibrarysList = new ArrayList<>();
        for (LibraryEntity library : list) {
            AddressEntity addressEntity = repositoryAddress.getAddress(library.getFkAddress());

            CompleteAddress completeAddress = CompleteAddress.from(
                    addressEntity.getStreet(),
                    addressEntity.getNumber(),
                    addressEntity.getIdAddress(),
                    addressEntity.getBoroughs(),
                    addressEntity.getCity(),
                    addressEntity.getState()
            );

            DataLibrarys dataLibrarys = new DataLibrarys(
                    library.getIdLibrary(),
                    library.getName(),
                    library.getFkAddress(),
                    completeAddress
            );

            dataLibrarysList.add(dataLibrarys);
        }

        return dataLibrarysList;
    }


    public void insert(LibraryEntity library)  {

        repository.insert(library.getName(), library.getFkAddress());
    }

    public void update(Integer id, LibraryEntity library) throws LibraryNotFound {
        LibraryEntity dataLibrary = repository.getLibraryById(id);
        if (dataLibrary == null) {
            throw new LibraryNotFound(id);
        }
        repository.update(library.getName(), library.getFkAddress(), id);
    }

    public void delete(Integer id) throws LibraryNotFound {
        LibraryEntity library = repository.getLibraryById(id);

        if (library == null) {
            throw new LibraryNotFound(id);
        }
        repository.deleteLibrary(id);
    }
}
