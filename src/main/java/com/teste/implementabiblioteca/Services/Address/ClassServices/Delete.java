package com.teste.implementabiblioteca.Services.Address.ClassServices;

import com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.AddressExceptions;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling.ErrorHandlingAddress.MapAddress;
import static com.teste.implementabiblioteca.Controller.Address.FormatterResponse.TypesResponseAddress.DeleteAddressSucessfull;
@Service
public class Delete {
    @Autowired
    private RepositoryAddress repository;

    public ResponseEntity<?> DeleteAddress(Integer id) {
        try {
            AddressEntity address = repository.getAddress(id);
            if (address == null) {
                throw new AddressNotFound(id);
            }
            repository.deleteAddress(id);
        } catch (AddressExceptions e) {
            return MapAddress(e);

        }
        return DeleteAddressSucessfull(id);
    }
}
