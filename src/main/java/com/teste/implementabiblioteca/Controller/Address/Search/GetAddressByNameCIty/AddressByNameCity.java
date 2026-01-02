package com.teste.implementabiblioteca.Controller.Address.Search.GetAddressByNameCIty;

import com.teste.implementabiblioteca.Controller.Address.Search.GetAddressByNameCIty.DTO.Response;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.ServicesAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.teste.implementabiblioteca.Controller.Address.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AddressByNameCity {
    @Autowired
    private ServicesAddress services;

    @GetMapping("/AddressByCity/{cidade}")
    public ResponseEntity<?> getAddressByNameCIty(@PathVariable String cidade){
        try {
            List<AddressEntity> listAddress = services.getAddressByCityName(cidade);

            return ResponseEntity.status(OK).body(Response.from(listAddress));
        } catch (Throwable e) {
            return map(e);
        }
    }
}
