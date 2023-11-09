package com.teste.implementabiblioteca.Controller.Author.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Author.Exceptions.*;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {

    public static ResponseEntity<?> map(Throwable pattern) {

        switch (pattern.getClass().getSimpleName()) {
            case "AuthorNotFound" -> {
                return convert((AuthorNotFound) pattern);
                /* quando a exceção for alguns dos casos ,
                vai converter a exceção padrão,  chamada de pattern para o tipo personalizado
                 descrito na string */
            }
            case "ListEmptyException" -> {
                return convert((LastNameNotFound) pattern);
            }
            case "DateBirthNotFound" -> {
                return convert((DateBirthNotFound) pattern);
            }
            case "ListNotFound" -> {
                return convert((RegisterNotFound) pattern);
            }
            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(pattern.getMessage());
                //quando nenhum dos casos no switch corresponde a uma exceção específica criada,
                // ele cai no caso padrão(default)  e cria uma resposta de erro com status
                // INTERNAL_SERVER_ERROR ,  e usa pattern.getMessage() para obter a mensagem
                // de erro da exceção não tratada.
                // Se a exceção não tiver uma mensagem personalizada, o método .getMessage()
                // retornará null ou uma representação padrão da exceção,
                // que pode não ser muito informativa.
            }
        }
    }

    public static ResponseEntity<?> convert(AuthorNotFound notFound) {
        return ResponseEntity.status(NOT_FOUND).body(notFound.getMessage());
    }

    public static ResponseEntity<?> convert(LastNameNotFound lastNameNotFound) {
        return ResponseEntity.status(NOT_FOUND).body(lastNameNotFound.getMessage());
    }

    public static ResponseEntity<?> convert(DateBirthNotFound birthNotFound) {
        return ResponseEntity.status(NOT_FOUND).body(birthNotFound.getMessage());
    }

    public static ResponseEntity<?> convert(RegisterNotFound emptyRegistration) {
        return ResponseEntity.status(NOT_FOUND).body(emptyRegistration.getMessage());
    }
}
