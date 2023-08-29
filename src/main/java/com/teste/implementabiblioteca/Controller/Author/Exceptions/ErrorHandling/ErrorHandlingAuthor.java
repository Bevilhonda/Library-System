package com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Model.Author.TypeExceptions.*;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

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
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }
    public static ResponseEntity<?> Convert(AuthorNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "O Autor com o id " + e.getId() + " não  foi encontrado.");
    }

    public static ResponseEntity<?> Convert(LastNameNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "Não existe o sobrenome " + e.GetLastName() + " no cadastro ");
    }

    public static ResponseEntity<?> Convert(ErrorSavingAuthor e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                "Não foi possivel inserir o autor.");
    }
    public static ResponseEntity<?> Convert(DateBirthNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "Não contém as datas Inicio: " + e.getStartDate() + " Fim: " + e.getFinalDate());
    }
    public static ResponseEntity<?> Convert(ListEmpty e) {
        return ResponseEntity.status(NOT_FOUND).body("A lista é vazia ");
    }
}
