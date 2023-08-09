package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.MonitorExceptions.AddressNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.FormatterResponses.ResponseFormatterAddress.FormatterAddressResponse;
import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAddress;
import static com.teste.implementabiblioteca.Services.TypesResponseAddress.*;

@Service
public class Address {
    @Autowired
    private RepositoryAddress repositoryAddress;

    public ResponseEntity<?> GetAddressById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AddressEntity address = repositoryAddress.GetAddress(id);

            if (address == null) {
                throw new AddressNotFound(id);
            }
            return FormatterAddressResponse(address);

        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);
        }
    }

    public ResponseEntity<?> InsertAddress(AddressEntity address) {
        try {
            Integer insertAddress = repositoryAddress.Insert(address.getIdAddress(), address.getStreet(), address.getNumber(), address.getZone(),
                    address.getCity(), address.getState());
            if (insertAddress == null) {
                throw new ErrorSavingAddress();
            }

            return SaveAddressSucessfull();

        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);
        }
    }

    public ResponseEntity<?> DeleteAddress(Integer id) {
        try {
            AddressEntity address = repositoryAddress.GetAddress(id);
            if (address == null) {
                throw new AddressNotFound(id);
            }
        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);

        }
        return DeleteAddressSucessfull(id);
    }
}
