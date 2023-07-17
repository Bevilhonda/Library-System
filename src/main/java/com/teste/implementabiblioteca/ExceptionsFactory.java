package com.teste.implementabiblioteca;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class ExceptionsFactory {
    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AutorNotFound" -> {
                AutorNotFound autorNotFound = (AutorNotFound) e;
                return ResponseEntity.status(autorNotFound.getStatus()).body(autorNotFound.getMensagem());
            }
            case "ListEmptyException" -> {
                LastNameNotFound lastNameNotFound = (LastNameNotFound) e;
                return ResponseEntity.status(lastNameNotFound.getStatus()).body(lastNameNotFound.getMensagem());
            }
            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }
}
