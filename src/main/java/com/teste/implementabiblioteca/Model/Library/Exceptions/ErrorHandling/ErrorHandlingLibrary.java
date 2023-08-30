package com.teste.implementabiblioteca.Model.Library.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.TypeExceptions.NameLibraryNotFound;
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
            case "ErrorSavingLibrary" -> {
                return Convert((ErrorSavingLibrary) e);
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
    public static ResponseEntity<?> Convert(ErrorSavingLibrary e) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ("Não foi possivel inserir o autor.");
        return ResponseEntity.status(statusCode).body(message);
    }

}
