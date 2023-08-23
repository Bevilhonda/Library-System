package com.teste.implementabiblioteca.Controller.Address.DAO;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Services.Address.ClassServices.ById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.TypesResponseAddress.UpdateAddressSucessfull;
import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;

@Service
public class AddressDAO {
    @Autowired
    private RepositoryAddress repositoryAddress;
    @Autowired
    private ById service;

    public ResponseEntity<?> UpdateAddress(Integer id, AddressEntity address) {
        try {
            service.GetAddressById(id);
            if (id == null) {
                throw new AddressNotFound(id);
            }
            repositoryAddress.updateAddress(address.getStreet(), address.getNumber(), address.getZone(),
                    address.getCity(), address.getState(), id);

            return UpdateAddressSucessfull(id);

        } catch (AddressExceptions e) {
            return MapAddress(e);
        }
    }

}
