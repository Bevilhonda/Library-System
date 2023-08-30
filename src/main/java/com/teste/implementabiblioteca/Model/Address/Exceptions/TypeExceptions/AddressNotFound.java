package com.teste.implementabiblioteca.Model.Address.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Model.Address.Exceptions.TypeExceptions.AddressExceptions;

public class AddressNotFound extends AddressExceptions {
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
