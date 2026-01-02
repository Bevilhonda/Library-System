package com.teste.implementabiblioteca.Controller.Book.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Model.Book.Exceptions.RegisterBookNotFound;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable standard) {

        switch (standard.getClass().getSimpleName()) {
            case "BookNotFound" -> {
                return convert((BookNotFound) standard);
            }
            case "RegisterBookNotFound" -> {
                return convert((RegisterBookNotFound) standard);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(standard.getMessage());
            }
        }
    }

    public static ResponseEntity<?> convert(BookNotFound notFound) {
        return ResponseEntity.status(NOT_FOUND).body(notFound.getMessage());
    }

    public static ResponseEntity<?> convert(RegisterBookNotFound notRegister) {

        return ResponseEntity.status(NOT_FOUND).body(notRegister.getMessage());
    }
}
