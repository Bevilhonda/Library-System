package com.teste.implementabiblioteca.Controller.Address.Insert;

import com.teste.implementabiblioteca.Services.Address;
import com.teste.implementabiblioteca.Controller.Address.DAO.DataAddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertAddress {
    @Autowired
    private Address address;
    @PostMapping("/InsertAddress")
    public ResponseEntity<?> insertAddress(@RequestBody DataAddressEntity newAddress) {
        return address.InsertAddress(newAddress.toModel());
    }
}
