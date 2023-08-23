package com.teste.implementabiblioteca.Controller.Library.DAO;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.LibraryExceptions;
import com.teste.implementabiblioteca.Controller.Library.Exceptions.TypeExceptions.NameLibraryNotFound;

import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;

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
                    AddressEntity address = repositoryAddress.getAddress(library.getFkAddress());
                    String addressDetails = ", ID Endereço: " + library.getFkAddress()
                            + ", Rua: " + address.getStreet()
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

        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }
    }
}
