package com.teste.implementabiblioteca.Services.Address.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Address.Exceptions.ErrorHandling.AddressExceptions;

public class AddressNotFound extends AddressExceptions {
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
