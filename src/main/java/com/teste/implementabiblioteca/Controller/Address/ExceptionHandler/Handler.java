package com.teste.implementabiblioteca.Controller.Address.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Address.Exceptions.AddressNotFound;
import com.teste.implementabiblioteca.Model.Address.Exceptions.ErrorSavingAddress;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable pattern) {

        switch (pattern.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
                return Convert((AddressNotFound) pattern);
            }
            case "ErrorSavingAddress" -> {
                return Convert((ErrorSavingAddress) pattern);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(pattern.getMessage());
            }
        }
    }

    public static ResponseEntity<?> Convert(AddressNotFound notFound) {
        return ResponseEntity.status(NOT_FOUND).body(notFound.getMessage());
    }

    public static ResponseEntity<?> Convert(ErrorSavingAddress errorSaving) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorSaving.getMessage());
    }
}
