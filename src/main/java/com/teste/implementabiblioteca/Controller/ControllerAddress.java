package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.DAO.AddressDAO;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address;
import com.teste.implementabiblioteca.repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerAddress {

    @Autowired
    private RepositoryAddress addressEntity ;
    @Autowired
    private Address address;
    @Autowired
    private AddressDAO addressDAO;

    @GetMapping("/Address/Id")
    public ResponseEntity<?> GetAddressById (@RequestParam(value = "id_endereco") Integer id){
        return  address.GetAddressById(id);
    }

    @PostMapping("/Insert")
    public AddressEntity InsertAddress(@RequestBody AddressEntity address){
        return addressEntity.save(address);
    }
    @PutMapping("/UpdateAddress")
    public ResponseEntity<?> Update(@RequestParam(value = "id_endereco") Integer id,
                                    @RequestBody AddressEntity address ){
        return addressDAO.UpdateAddress(id,address);
    }

}
