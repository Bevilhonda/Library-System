package com.teste.implementabiblioteca.MonitorExceptions;

import com.teste.implementabiblioteca.Controller.Address.MonitorExeptions.AddressNotFound;
import com.teste.implementabiblioteca.Controller.Address.MonitorExeptions.ErrorSavingAddress;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.ErrorSavingAuthor;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.LastNameNotFound;
import com.teste.implementabiblioteca.Controller.Book.MonitorExeptions.BookNotFound;
import com.teste.implementabiblioteca.Controller.Library.MonittorExceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Controller.Library.MonittorExceptions.NameLibraryNotFound;
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
            case "ErrorSavingAuthor" -> {
                return Convert((ErrorSavingAuthor) e);
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


    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public static ResponseEntity<?> MapLibrary(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "LibraryNotFound" -> {
                return Convert((LibraryNotFound) e);
            }
            case "NameLibraryNotFound" -> {
                return Convert((NameLibraryNotFound) e);
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
        String message = "A Biblioteca com o nome " + e.getName() + " não  foi encontrada.";
        return ResponseEntity.status(statusCode).body(message);
    }
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public static ResponseEntity<?> MapAddress(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AddressNotFound" -> {
                return Convert((AddressNotFound) e);
            }
            case "ErrorSavingAddress" -> {
                return Convert((ErrorSavingAddress) e);
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

    public static ResponseEntity<?> Convert(ErrorSavingAddress e) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ("Não foi possivel inserir o endereço.");
        return ResponseEntity.status(statusCode).body(message);
    }
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

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


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public static ResponseEntity<?> MapDateBirth(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "DateBirthNotFound" -> {
                return Convert((DateBirthNotFound) e);
            }

            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> Convert(DateBirthNotFound e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "Não contém as datas Inicio: " + e.getStartDate() + " Fim: " + e.getFinalDate();
        return ResponseEntity.status(statusCode).body(message);
    }
}
