package com.teste.implementabiblioteca.Services.Address.ClassServices;
import com.teste.implementabiblioteca.Controller.Address.Exceptions.TypeExceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Delete {
    @Autowired
    private RepositoryAddress repository;

    public Integer DeleteAddress(Integer id) throws AddressNotFound {

            AddressEntity address = repository.getAddress(id);
            if (address == null) {
                throw new AddressNotFound(id);
            }
            repository.deleteAddress(id);
        return id;
    }
}
