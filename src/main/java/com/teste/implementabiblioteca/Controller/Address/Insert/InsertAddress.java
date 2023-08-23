package com.teste.implementabiblioteca.Controller.Address.Insert;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Controller.Address.Update.DTO.DataAddressEntity;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.ClassServices.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertAddress {
    @Autowired
    private Insert service;

    @PostMapping("/InsertAddress")
    public ResponseEntity<?> insertAddress(@RequestBody DataAddressEntity newAddress) {
        try {
            AddressEntity addressEntity = service.InsertAddress(newAddress.toModel());
            if (addressEntity == null ){
                throw new ErrorSavingAddress();
            }
            return ResponseEntity.status(OK).build();

        } catch (AddressExceptions e) {
            throw new RuntimeException(e);
        }
    }
}
