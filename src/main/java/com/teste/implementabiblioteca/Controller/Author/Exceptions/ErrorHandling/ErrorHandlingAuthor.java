package com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandlingAuthor {

    public static ResponseEntity<?> MapAuthor(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AutorNotFound" -> {
                return Convert((AuthorNotFound) e);
            }
            case "ListEmptyException" -> {
                return Convert((LastNameNotFound) e);
            }
            case "ErrorSavingAuthor" -> {
                return Convert((ErrorSavingAuthor) e);
            }
            case "DateBirthNotFound" -> {
                return Convert((DateBirthNotFound) e);
            }
            case "ListEmpty" -> {
                return Convert((ListEmpty) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }
    public static ResponseEntity<?> Convert(AuthorNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "O Autor com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(statusCode).body(message);
    }

    public static ResponseEntity<?> Convert(LastNameNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "Não existe o sobrenome " + e.GetLastName() + " no cadastro ";
        return ResponseEntity.status(statusCode).body(message);
    }

    public static ResponseEntity<?> Convert(ErrorSavingAuthor e) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ("Não foi possivel inserir o autor.");
        return ResponseEntity.status(statusCode).body(message);
    }
    public static ResponseEntity<?> Convert(DateBirthNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "Não contém as datas Inicio: " + e.getStartDate() + " Fim: " + e.getFinalDate();
        return ResponseEntity.status(statusCode).body(message);
    }
    public static ResponseEntity<?> Convert(ListEmpty e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "A lista é vazia " ;
        return ResponseEntity.status(statusCode).body(message);
    }
}
