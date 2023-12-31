package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress;

import com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO.Response;
import com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO.LibraryAddressDTO;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FullLibrary {

    @Autowired
    private ServicesLibrary services;

    @GetMapping("/FullLibraries")
    public ResponseEntity<?> getAllLibrary(){
        try {
            List<LibraryAddressDTO> listLibrary = services.getAllLibraryAndAddress();

            return ResponseEntity.status(OK).body(Response.from(listLibrary));

        } catch (Throwable e) {
            return map(e);
        }
    }
}
