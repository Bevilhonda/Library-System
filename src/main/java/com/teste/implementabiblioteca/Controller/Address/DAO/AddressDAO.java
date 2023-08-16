package com.teste.implementabiblioteca.Controller.Address.DAO;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Services.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Services.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Services.Address.Address;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.TypesResponseAddress.UpdateAddressSucessfull;
import static com.teste.implementabiblioteca.Services.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;

@Service
public class AddressDAO {
    @Autowired
    private RepositoryAddress repositoryAddress;
    @Autowired
    private Address addressTemporary;

    public ResponseEntity<?> UpdateAddress(Integer id, AddressEntity address) {
        try {
            addressTemporary.GetAddressById(id);
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
