package com.teste.implementabiblioteca.Controller.Address.Search;

import com.teste.implementabiblioteca.Services.Address.ClassServices.ById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByIdAddress {
    @Autowired
    private ById services;
    @GetMapping("/Address/{id}")
    public ResponseEntity<?> GetAddressById(@PathVariable Integer id) {
        return services.GetAddressById(id);
    }
}
