package com.teste.implementabiblioteca.Model.Library.Exceptions;

public class RegisterLibraryNotFound extends LibraryExceptions{
    private final String message;

    public RegisterLibraryNotFound(){
        message = "Nenhuma Biblioteca foi cadastrada.";
    }
    public String message(){
        return message;
    }

}
