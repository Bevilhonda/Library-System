package com.teste.implementabiblioteca.Controller.Address.Delete;

import com.teste.implementabiblioteca.Services.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAddress {
    @Autowired
    private Address address;
    @DeleteMapping("/DeleteAddress/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        return address.DeleteAddress(id);
    }
}
