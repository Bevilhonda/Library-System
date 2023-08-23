package com.teste.implementabiblioteca.Controller.Address.Update;

import com.teste.implementabiblioteca.Controller.Address.Update.DTO.DataAddressEntity;
import com.teste.implementabiblioteca.Services.Address.ClassServices.ById;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static org.springframework.http.HttpStatus.*;

@RestController
public class UpdateAddress {
    @Autowired
    private ById service;

    @PutMapping("/UpdateAddress/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id,
                                           @RequestBody DataAddressEntity dataAddress) {
        try {
            AddressEntity address = service.UpdateAddress(id, dataAddress.toModel());
            if (address == null){
                throw new AddressNotFound(id);
            }
            return ResponseEntity.status(OK).build();

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }

    }
}
