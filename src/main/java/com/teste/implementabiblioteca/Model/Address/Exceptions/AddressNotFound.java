package com.teste.implementabiblioteca.Model.Address.Exceptions;

public class AddressNotFound extends AddressExceptions {
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
