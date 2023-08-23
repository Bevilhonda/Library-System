package com.teste.implementabiblioteca.Services.Address.ClassServices;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Update {
    @Autowired
    private RepositoryAddress repositoryAddress;
    public AddressEntity UpdateAddress(Integer id, AddressEntity addressEntity) throws AddressNotFound {
        AddressEntity addressId = repositoryAddress.getAddress(id);

        if (id == null) {
            throw new AddressNotFound(id);
        }
        repositoryAddress.updateAddress(addressEntity.getStreet(), addressEntity.getNumber(),
                addressEntity.getZone(),addressEntity.getCity(), addressEntity.getState(), id);
        return addressEntity;
    }
}
