package com.teste.implementabiblioteca.Controller.Address.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Model.Address.TypeExceptions.Address.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.TypeExceptions.Address.ErrorSavingAddress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandlingAddress {
    public static ResponseEntity<?> MapAddress(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
                return Convert((AddressNotFound) e);
            }
            case "ErrorSavingAddress" -> {
                return Convert((ErrorSavingAddress) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> Convert(AddressNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "O endereço com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(statusCode).body(message);
    }

    public static ResponseEntity<?> Convert(ErrorSavingAddress e) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ("Não foi possivel inserir o endereço.");
        return ResponseEntity.status(statusCode).body(message);
    }
}
