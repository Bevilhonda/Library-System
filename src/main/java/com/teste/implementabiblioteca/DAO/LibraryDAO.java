package com.teste.implementabiblioteca.DAO;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.MonitorExceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryAddress;
import com.teste.implementabiblioteca.repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapLibrary;

@Service
public class LibraryDAO {
    @Autowired
    private RepositoryLibrary repositoryLibrary;
    @Autowired
    private RepositoryAddress repositoryAddress;

    public LibraryDAO() {
    }

    public ResponseEntity<?> GetAllLibrary(String name) {
        try {
            List<LibraryEntity> libraries = repositoryLibrary.GetAllLibrary();

            if (libraries.isEmpty()) {
                throw new NameLibraryNotFound(name);
            }


            List<String> libraryDetailsList = new ArrayList<>();
            for (LibraryEntity library : libraries) {
                if (Objects.equals(library.getName(), name)) {
                    AddressEntity address = repositoryAddress.GetAddress(library.getFkAddress());
                    String addressDetails = ", ID Endereço: " + library.getFkAddress()
                            + ", Rua: " + address.getstreet()
                            + ", Número: " + address.getNumber()
                            + ", Bairro: " + address.getZone()
                            + ", Cidade: " + address.getCity()
                            + ", Estado: " + address.getState();

                    String libraryDetails = ", ID Biblioteca: " + library.getIdLibrary()
                            + ", Nome: " + library.getName()
                            + ", Endereço: " + addressDetails;

                    libraryDetailsList.add(libraryDetails);
                }
            }

            return new ResponseEntity<>(libraryDetailsList, HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapLibrary(e);
        }
    }
}
