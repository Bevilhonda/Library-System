package com.teste.implementabiblioteca.Services.Address;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesAddress {
    @Autowired
    private RepositoryAddress repository;

    public AddressEntity getAddresById(Integer id) throws AddressNotFound {
        AddressEntity addressEntity = repository.getAddress(id);
        if (addressEntity == null) {
            throw new AddressNotFound(id);
        }
        return addressEntity;
    }

    public List<AddressEntity> allAddress() {
        return null;
    }

    public AddressEntity insertAddress(AddressEntity address) throws ErrorSavingAddress {

        Integer insertAddress = repository.saveAddress(address.getIdAddress(), address.getStreet(), address.getNumber(), address.getZone(),
                address.getCity(), address.getState());
        if (insertAddress == null) {
            throw new ErrorSavingAddress();
        }
        return address;
    }

    public AddressEntity updateAddress(Integer id, AddressEntity addressEntity) throws AddressNotFound {
        AddressEntity addressId = repository.getAddress(id);

        if (id == null) {
            throw new AddressNotFound(id);
        }
        repository.updateAddress(addressEntity.getStreet(), addressEntity.getNumber(),
                addressEntity.getZone(),addressEntity.getCity(), addressEntity.getState(), id);
        return addressEntity;
    }
    public void deleteAddress(Integer id) throws AddressNotFound {

        AddressEntity address = repository.getAddress(id);
        if (address == null) {
            throw new AddressNotFound(id);
        }
        repository.deleteAddress(id);
    }
}
