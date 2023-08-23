package com.teste.implementabiblioteca.Services.Address.ClassServices;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ById {
    @Autowired
    private RepositoryAddress repositoryAddress;
    public AddressEntity getAddresById(Integer id) throws AddressNotFound{
        AddressEntity addressEntity = repositoryAddress.getAddress(id);
        if (addressEntity == null){
            throw new AddressNotFound(id);
        }
        return addressEntity;
    }

}
