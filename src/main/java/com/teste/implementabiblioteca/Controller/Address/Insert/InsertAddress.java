package com.teste.implementabiblioteca.Controller.Address.Insert;

import com.teste.implementabiblioteca.Controller.Address.Update.DTO.DataAddressEntity;

import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Book.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertAddress {
    @Autowired
    private ServicesAddress service;

    @PostMapping("/Insert/Address")
    public ResponseEntity<?> insertAddress(@RequestBody @Valid DataAddressEntity newAddress) {
        try {
            service.insertAddress(newAddress.toModel());

            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
