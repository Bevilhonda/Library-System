package com.teste.implementabiblioteca.MonitorExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionsFactory {
    public static ResponseEntity<?> MapAuthor(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AutorNotFound" -> {
                return Convert((AuthorNotFound) e);
            }
            case "ListEmptyException" -> {
                return Convert((LastNameNotFound) e);
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


    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public static ResponseEntity<?> MapLibrary(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "LibraryNotFound" -> {
                return Convert((LibraryNotFound) e);
            }
            case "NameLibraryNotFound" ->{
                return Convert((NameLibraryNotFound)e);
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
        String message = "A Biblioteca com o nome " + e.getNome() + " não  foi encontrada.";
        return ResponseEntity.status(statusCode).body(message);
    }
 //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public static ResponseEntity<?> MapAddress(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
                return Convert((AddressNotFound) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }
    public static ResponseEntity<?> Convert(AddressNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "O endereço com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(statusCode).body(message);
    }
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public static ResponseEntity<?> MapBook(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
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
