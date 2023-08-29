package com.teste.implementabiblioteca.Model.Address.TypeExceptions.Address;

public class AddressNotFound extends AddressExceptions {
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
