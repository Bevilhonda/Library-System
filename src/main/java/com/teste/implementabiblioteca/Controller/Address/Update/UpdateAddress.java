package com.teste.implementabiblioteca.Controller.Address.Update;

import com.teste.implementabiblioteca.Controller.Address.Update.DTO.DataAddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.TypeExceptions.AddressExceptions;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Model.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static org.springframework.http.HttpStatus.*;

@RestController
public class UpdateAddress {
    @Autowired
    private ServicesAddress service;

    @PutMapping("/UpdateAddress/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id,
                                           @RequestBody DataAddressEntity dataAddress) {
        try {
             service.updateAddress(id, dataAddress.toModel());

            return ResponseEntity.status(OK).build();

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }
}
