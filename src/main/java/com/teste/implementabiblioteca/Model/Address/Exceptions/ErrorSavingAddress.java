package com.teste.implementabiblioteca.Model.Address.Exceptions;

public class ErrorSavingAddress extends AddressExceptions {
    private final String message ;

    public ErrorSavingAddress() {
        message = "Erro ao salvar endereço , preencha os campos novamente. ";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
