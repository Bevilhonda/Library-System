package com.teste.implementabiblioteca.Controller.Library.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.RegisterLibraryNotFound;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable standard) {

        switch (standard.getClass().getSimpleName()) {
            case "LibraryNotFound" -> {
                return convert((LibraryNotFound) standard);
            }
            case "NameLibraryNotFound" -> {
                return convert((NameLibraryNotFound) standard);
            }
            case "RegisterLibraryNotFound" -> {
                return convert((RegisterLibraryNotFound) standard);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(standard.getMessage());
            }
        }
    }

    public static ResponseEntity<?> convert(LibraryNotFound notFound) {
        return ResponseEntity.status(NOT_FOUND).body(notFound.getMessage());
    }

    public static ResponseEntity<?> convert(NameLibraryNotFound nameNotFound) {
        return ResponseEntity.status(NOT_FOUND).body(nameNotFound.getMessage());
    }

    public static ResponseEntity<?> convert(RegisterLibraryNotFound errorSaving) {
        return ResponseEntity.status(NOT_FOUND).body(errorSaving.getMessage());
    }

}
