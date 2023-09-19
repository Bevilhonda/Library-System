package com.teste.implementabiblioteca.Controller.Library.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Library.Exceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
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
            case "ErrorSavingLibrary" -> {
                return convert((ErrorSavingLibrary) standard);
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

    public static ResponseEntity<?> convert(ErrorSavingLibrary errorSaving) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorSaving.getMessage());
    }

}
