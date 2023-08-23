package com.teste.implementabiblioteca.Services.Address.ClassServices;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.TypesResponseAddress.SaveAddressSucessfull;
@Service
public class Insert {
    @Autowired
    private RepositoryAddress repository;
    public ResponseEntity<?> InsertAddress(AddressEntity address) {
        try {
            Integer insertAddress = repository.saveAddress(address.getIdAddress(), address.getStreet(), address.getNumber(), address.getZone(),
                    address.getCity(), address.getState());
            if (insertAddress == null) {
                throw new ErrorSavingAddress();
            }

            return SaveAddressSucessfull();

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }
}
