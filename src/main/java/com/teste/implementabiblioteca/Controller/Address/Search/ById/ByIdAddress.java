package com.teste.implementabiblioteca.Controller.Address.Search.ById;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Controller.Address.Search.ById.DTO.Response;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static org.springframework.http.HttpStatus.*;

@RestController
public class ByIdAddress {
    @Autowired
    private Services services;
    @GetMapping("/Address/{id}")
    public ResponseEntity<?> GetAddressById(@PathVariable Integer id) {
        try {
            AddressEntity addressEntity = services.getAddresById(id);
            if (addressEntity== null){
                throw new AddressNotFound(id);
            }
            return ResponseEntity.status(OK).body(Response.from(addressEntity));

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }
}
