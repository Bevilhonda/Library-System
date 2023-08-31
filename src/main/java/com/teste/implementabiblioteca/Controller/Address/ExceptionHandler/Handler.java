package com.teste.implementabiblioteca.Controller.Address.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.Exceptions.ErrorSavingAddress;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
                return Convert((AddressNotFound) e);
            }
            case "ErrorSavingAddress" -> {
                return Convert((ErrorSavingAddress) e);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                        "Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> Convert(AddressNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body("O endereço com o id " + e.getId() +
                " não  foi encontrado.");
    }

    public static ResponseEntity<?> Convert(ErrorSavingAddress e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                "Não foi possivel inserir o endereço.");
    }
}
