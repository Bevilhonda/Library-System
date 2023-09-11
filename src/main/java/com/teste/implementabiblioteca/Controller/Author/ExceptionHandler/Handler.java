package com.teste.implementabiblioteca.Controller.Author.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Author.Exceptions.*;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {

    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AuthorNotFound" -> {
                return convert((AuthorNotFound) e);
            }
            case "ListEmptyException" -> {
                return convert((LastNameNotFound) e);
            }
            case "ErrorSavingAuthor" -> {
                return convert((ErrorSavingAuthor) e);
            }
            case "DateBirthNotFound" -> {
                return convert((DateBirthNotFound) e);
            }
            case "ListNotFound" -> {
                return convert((ListNotFound) e);
            }
            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocorreu um erro durante a operação.");
            }
        }
    }
    public static ResponseEntity<?> convert(AuthorNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "O Autor com o id " + e.getId() + " não  foi encontrado.");
    }

    public static ResponseEntity<?> convert(LastNameNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "Não existe o sobrenome " + e.GetLastName() + " no cadastro ");
    }

    public static ResponseEntity<?> convert(ErrorSavingAuthor e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    public static ResponseEntity<?> convert(DateBirthNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "Não contém as datas Inicio: " + e.getStartDate() +
                        " Fim: " + e.getFinalDate());
    }
    public static ResponseEntity<?> convert(ListNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }
}
