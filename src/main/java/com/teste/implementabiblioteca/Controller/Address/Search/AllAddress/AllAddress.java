package com.teste.implementabiblioteca.Controller.Address.Search.AllAddress;

import com.teste.implementabiblioteca.Controller.Address.Search.AllAddress.DTO.Response;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Author.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class AllAddress {
    @Autowired
    private ServicesAddress services;
    @GetMapping("/Address")
    public ResponseEntity<?> getAllAuthors() {
        try {
            List<AddressEntity> listAddress = services.getAllAddress();

            return ResponseEntity.status(OK).body(Response.from(listAddress));

        } catch (Throwable e) {
            return map(e);
        }
    }
}
