package com.teste.implementabiblioteca.Services.Address;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.Exceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Model.Address.AddressEntity;
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

    public List<AddressEntity> getAll() {
        return null;
    }

    public void insertAddress(AddressEntity address) throws ErrorSavingAddress {

        Integer insertAddress = repository.saveAddress( address.getStreet(), address.getNumber(), address.getNeighborhood(),
                address.getCity(), address.getState());
        if (insertAddress == null) {
            throw new ErrorSavingAddress();
        }
    }

    public void updateAddress(Integer id, AddressEntity addressEntity) throws AddressNotFound {
        AddressEntity addressId = repository.getAddress(id);

        if (id == null) {
            throw new AddressNotFound(id);
        }
        repository.updateAddress(addressEntity.getStreet(), addressEntity.getNumber(),
                addressEntity.getNeighborhood(),addressEntity.getCity(), addressEntity.getState(), id);
    }
    public void deleteAddress(Integer id) throws AddressNotFound {

        AddressEntity address = repository.getAddress(id);
        if (address == null) {
            throw new AddressNotFound(id);
        }
        repository.deleteAddress(id);
    }
}
