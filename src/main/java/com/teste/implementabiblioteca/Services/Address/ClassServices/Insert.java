package com.teste.implementabiblioteca.Services.Address.ClassServices;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class Insert {
    @Autowired
    private RepositoryAddress repository;

    public AddressEntity InsertAddress(AddressEntity address) throws ErrorSavingAddress {

        Integer insertAddress = repository.saveAddress(address.getIdAddress(), address.getStreet(), address.getNumber(), address.getZone(),
                address.getCity(), address.getState());
        if (insertAddress == null) {
            throw new ErrorSavingAddress();
        }
        return address;
    }
}
