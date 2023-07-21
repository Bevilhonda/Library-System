package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Services.Address;
import com.teste.implementabiblioteca.repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAddress {

    @Autowired
    private RepositoryAddress addressEntity ;

    @Autowired
    private Address address;

    @GetMapping("/Address/Id")
    public ResponseEntity<?> GetAddressById (@RequestParam(value = "id_endereco") Integer id){
        return  address.GetAddressById(id);
    }

}
