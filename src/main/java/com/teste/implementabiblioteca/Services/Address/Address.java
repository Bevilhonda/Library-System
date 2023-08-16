package com.teste.implementabiblioteca.Services.Address;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Services.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Services.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.ResponseFormatterAddress.FormatterAddressResponse;
import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.TypesResponseAddress.*;
import static com.teste.implementabiblioteca.Services.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;

@Service
public class Address {
    @Autowired
    private RepositoryAddress repositoryAddress;

    public ResponseEntity<?> GetAddressById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AddressEntity address = repositoryAddress.getAddress(id);

            if (address == null) {
                throw new AddressNotFound(id);
            }
            return FormatterAddressResponse(address);

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }

    public ResponseEntity<?> InsertAddress(AddressEntity address) {
        try {
            Integer insertAddress = repositoryAddress.saveAddress(address.getIdAddress(), address.getStreet(), address.getNumber(), address.getZone(),
                    address.getCity(), address.getState());
            if (insertAddress == null) {
                throw new ErrorSavingAddress();
            }

            return SaveAddressSucessfull();

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }

    public ResponseEntity<?> DeleteAddress(Integer id) {
        try {
            AddressEntity address = repositoryAddress.getAddress(id);
            if (address == null) {
                throw new AddressNotFound(id);
            }
            repositoryAddress.deleteAddress(id);
        } catch (AddressExceptions e) {
            return MapAddress(e);

        }
        return DeleteAddressSucessfull(id);
    }
}
