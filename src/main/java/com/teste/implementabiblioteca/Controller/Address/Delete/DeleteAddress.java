package com.teste.implementabiblioteca.Controller.Address.Delete;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static org.springframework.http.HttpStatus.*;

@RestController
public class DeleteAddress {
    @Autowired
    private ServicesAddress service;

    @DeleteMapping("/DeleteAddress/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        try {
            service.deleteAddress(id);

            return ResponseEntity.status(OK).build();

        } catch (AddressExceptions e) {
          return MapAddress(e);
        }
    }
}
