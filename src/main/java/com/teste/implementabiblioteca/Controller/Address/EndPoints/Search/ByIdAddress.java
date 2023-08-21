package com.teste.implementabiblioteca.Controller.Address.EndPoints.Search;

import com.teste.implementabiblioteca.Services.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByIdAddress {
    @Autowired
    private Address address;
    @GetMapping("/Address/{id}")
    public ResponseEntity<?> GetAddressById(@PathVariable Integer id) {
        return address.GetAddressById(id);
    }
}
