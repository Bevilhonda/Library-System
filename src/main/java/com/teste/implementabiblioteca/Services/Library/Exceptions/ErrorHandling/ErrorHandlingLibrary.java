package com.teste.implementabiblioteca.Services.Library.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Services.Library.Exceptions.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Services.Library.Exceptions.TypeExceptions.NameLibraryNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandlingLibrary {
    public static ResponseEntity<?> MapLibrary(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "LibraryNotFound" -> {
                return Convert((LibraryNotFound) e);
            }
            case "NameLibraryNotFound" -> {
                return Convert((NameLibraryNotFound) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> Convert(LibraryNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "A Biblioteca com o id " + e.getId() + " não  foi encontrada.";
        return ResponseEntity.status(statusCode).body(message);
    }

    public static ResponseEntity<?> Convert(NameLibraryNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "A Biblioteca com o nome " + e.getName() + " não  foi encontrada.";
        return ResponseEntity.status(statusCode).body(message);
    }

}
