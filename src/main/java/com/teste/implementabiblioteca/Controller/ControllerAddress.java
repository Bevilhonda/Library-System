package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.DAO.AddressDAO;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address;
import com.teste.implementabiblioteca.Services.DataAddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerAddress {
    @Autowired
    private Address address;
    @Autowired
    private AddressDAO addressDAO;

    @GetMapping("/Address/{id}")
    public ResponseEntity<?> GetAddressById(@PathVariable Integer id) {
        return address.GetAddressById(id);
    }

    @PostMapping("/InsertAddress")
    public ResponseEntity<?> InsertAddress(@RequestBody DataAddressEntity newAddress) {
        return address.InsertAddress(newAddress.toModel());
    }

    @PutMapping("/UpdateAddress/{id}")
    public ResponseEntity<?> UpdateAddress(@PathVariable Integer id,
                                           @RequestBody AddressEntity dataAddress) {
        return addressDAO.UpdateAddress(id, dataAddress);
    }

    @DeleteMapping("/DeleteAddress/{id}")
    public ResponseEntity<?> DeleteAddress(@PathVariable Integer id) {
        return DeleteAddress(id);
    }

}
