package com.teste.implementabiblioteca.Controller.Address.Update;

import com.teste.implementabiblioteca.Controller.Address.DAO.AddressDAO;
import com.teste.implementabiblioteca.Model.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateAddress {
    @Autowired
    private AddressDAO addressDAO;

    @PutMapping("/UpdateAddress/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id,
                                           @RequestBody AddressEntity dataAddress) {
        return addressDAO.UpdateAddress(id, dataAddress);
    }

}
