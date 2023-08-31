package com.teste.implementabiblioteca.Controller.Library.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Library.Exceptions.ErrorSavingLibrary;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Model.Library.Exceptions.NameLibraryNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "LibraryNotFound" -> {
                return convert((LibraryNotFound) e);
            }
            case "NameLibraryNotFound" -> {
                return convert((NameLibraryNotFound) e);
            }
            case "ErrorSavingLibrary" -> {
                return convert((ErrorSavingLibrary) e);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                        "Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> convert(LibraryNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "A Biblioteca com o id " + e.getId() + " não  foi encontrada.");
    }

    public static ResponseEntity<?> convert(NameLibraryNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "A Biblioteca com o nome " + e.getName() + " não  foi encontrada.");
    }

    public static ResponseEntity<?> convert(ErrorSavingLibrary e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                "Não foi possivel inserir o autor.");
    }

}
