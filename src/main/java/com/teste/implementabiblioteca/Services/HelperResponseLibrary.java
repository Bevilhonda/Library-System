package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Model.LibraryEntity;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class HelperResponseLibrary {
    @Autowired
    private AddressEntity address;

    public static ResponseEntity<?> DetailsLibrary(String message, HttpStatus responsestatus) {

        return ResponseEntity.status(responsestatus).body(message);
    }

    public static ResponseEntity<?> DetailsAllLibrary(List<LibraryEntity> listlibrary, HttpStatus currentstatus) {

        List<String> detaillibrarys = new ArrayList<>();

        for (LibraryEntity library : listlibrary) {

            String detaillibrary = "Id: " + library.getId_biblioteca() + " Nome: " + library.getNome() +
                    " Endereço: " + library.getFk_endereco();


            detaillibrarys.add(detaillibrary);
        }
        return ResponseEntity.status(currentstatus).body(detaillibrarys);
    }
}
