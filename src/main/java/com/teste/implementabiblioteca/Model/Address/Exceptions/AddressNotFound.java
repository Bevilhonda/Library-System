package com.teste.implementabiblioteca.Model.Address.Exceptions;

public class AddressNotFound extends AddressExceptions {
    private final Integer id ;
    private final String message;
    public AddressNotFound(Integer id ){
        this.id = id;
        message = "O endereço com o id " + getId() + " não foi encontrado.";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }
}
