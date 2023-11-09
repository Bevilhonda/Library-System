package com.teste.implementabiblioteca.Services.Address;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Address.Exceptions.RegisterAddressNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesAddress {
    @Autowired
    private RepositoryAddress repository;

    public AddressEntity getById(Integer id) throws AddressNotFound {
        AddressEntity addressEntity = repository.getAddress(id);
        if (addressEntity == null) {
            throw new AddressNotFound(id);
        }
        return addressEntity;
    }

    public List<AddressEntity> getAllAddress() throws RegisterAddressNotFound {
        List<AddressEntity> listAddress = repository.getAllAddress();
        if (listAddress.isEmpty()) {
            throw new RegisterAddressNotFound();
        }
        return listAddress;
    }

    public void insertAddress(AddressEntity address) {

        repository.saveAddress(address.getStreet(), address.getNumber(),
                address.getBoroughs(),address.getCity(), address.getState());

    }

    public void updateAddress(Integer id, AddressEntity addressEntity) throws AddressNotFound {
        AddressEntity address = repository.getAddress(id);

        if (address == null) {
            throw new AddressNotFound(id);
        }
        repository.updateAddress(addressEntity.getStreet(), addressEntity.getNumber(),
                addressEntity.getCity(),addressEntity.getBoroughs(), addressEntity.getState(), id);
    }

    public void deleteAddress(Integer id) throws AddressNotFound {

        AddressEntity address = repository.getAddress(id);

        if (address == null) {
            throw new AddressNotFound(id);
        }
        repository.deleteAddress(id);
    }
}
