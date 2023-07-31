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
import static com.teste.implementabiblioteca.Services.HelperResponseAddress.ReturnDetailsAddress;

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
            return ReturnDetailsAddress("Id: "+ address.getIdAddress() + "\n Rua: " +
                    address.getStreet() + "\n Numero: " + address.getNumber() + "\n Cidade: "
                    + address.getCity()+ "\n Bairro: " + address.getZone() + "\n Estado: " +
                    address.getState() , HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);
        }
    }

    public ResponseEntity<?> InsertAddress(AddressEntity address){
        try {
            repositoryAddress.Insert(address.getStreet(),address.getNumber(),address.getZone(),
                    address.getCity(),address.getState());

            return ReturnDetailsAddress("Adicionado",HttpStatus.OK);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
