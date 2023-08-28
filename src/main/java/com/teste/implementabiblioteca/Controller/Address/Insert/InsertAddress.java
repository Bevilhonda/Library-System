package com.teste.implementabiblioteca.Controller.Address.Insert;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Controller.Address.Update.DTO.DataAddressEntity;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;
import static org.springframework.http.HttpStatus.*;

@RestController
public class InsertAddress {
    @Autowired
    private ServicesAddress service;

    @PostMapping("/Insert/Address")
    public ResponseEntity<?> insertAddress(@RequestBody DataAddressEntity newAddress) {
        try {
            AddressEntity addressEntity = service.insertAddress(newAddress.toModel());
            if (addressEntity == null) {
                throw new ErrorSavingAddress();
            }
            return ResponseEntity.status(OK).build();

        } catch (AddressExceptions e) {
            return MapBook(e);
        }
    }
}
