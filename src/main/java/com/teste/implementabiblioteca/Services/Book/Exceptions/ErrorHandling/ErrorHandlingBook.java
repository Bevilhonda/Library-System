package com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Services.Book.Exceptions.TypeExceptions.BookNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandlingBook {
    public static ResponseEntity<?> MapBook(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "BookNotFound" -> {
                return Convert((BookNotFound) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> Convert(BookNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "O Livro com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(statusCode).body(message);
    }
}
