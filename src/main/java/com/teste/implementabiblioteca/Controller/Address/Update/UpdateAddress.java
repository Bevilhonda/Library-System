package com.teste.implementabiblioteca.Controller.Address.Update;

import com.teste.implementabiblioteca.Controller.Address.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Address.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UpdateAddress {
    @Autowired
    private ServicesAddress service;

    @PutMapping("/UpdateAddress/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id,
                                           @RequestBody @Valid RequestData dataAddress) {
        try {
             service.updateAddress(id, dataAddress.toModel());

            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
