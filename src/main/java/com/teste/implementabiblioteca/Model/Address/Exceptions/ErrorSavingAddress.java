package com.teste.implementabiblioteca.Model.Address.Exceptions;

public class ErrorSavingAddress extends AddressExceptions {
    private final String message ;

    public ErrorSavingAddress() {
        message = "Não foi possivel salvar este endereço.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
