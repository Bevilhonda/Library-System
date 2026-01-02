package com.teste.implementabiblioteca.Model.Address.Exceptions;

public class RegisterAddressNotFound extends AddressExceptions{
    private final String message;
    public RegisterAddressNotFound() {
        message = "Nenhum endereço foi cadastrado.";
    }

    public String getMessage() {
        return message;
    }

}
