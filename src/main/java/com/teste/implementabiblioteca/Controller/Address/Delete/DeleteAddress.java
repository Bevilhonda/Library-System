package com.teste.implementabiblioteca.Controller.Address.Delete;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressExceptions;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Address.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class DeleteAddress {
    @Autowired
    private ServicesAddress service;

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        try {
            service.deleteAddress(id);

            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
          return map(e);
        }
    }
}
