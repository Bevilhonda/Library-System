package com.teste.implementabiblioteca.DAO;

import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.MonitorExceptions.AddressNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.Services.Address;
import com.teste.implementabiblioteca.repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAddress;
import static com.teste.implementabiblioteca.Services.HelperResponseAddress.ReturnDetailsAddress;

@Service
public class AddressDAO {
    @Autowired
    private RepositoryAddress repositoryAddress;
    @Autowired
    private Address addressTemporary;
    public ResponseEntity<?> UpdateAddress(Integer id, AddressEntity address){
        try {
            addressTemporary.GetAddressById(id);
            if (id == null){
                throw new AddressNotFound(id);
            }
            repositoryAddress.UpdateAddress(address.getStreet(),address.getNumber(),address.getZone(),
                    address.getCity(),address.getState(),id);
            return ReturnDetailsAddress("Endereço atualizado com sucesso.", HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapAddress(e);
        }
    }

}
