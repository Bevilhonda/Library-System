package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.MonitorExceptions.AddressNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAddress;
import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.ReturnDetailsAuthor;

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
            return ReturnDetailsAuthor("Id: " + address.getIdAddress()+ "\n Street:  " +
                    address.getstreet() + "\n Number:  " +
                    address.getNumber() + "\n Zone: " + address.getZone() + "\n City: " +
                    address.getCity() + "\n State: " + address.getState()
                    , HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);
        }
    }
}
