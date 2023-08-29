package com.teste.implementabiblioteca.Controller.Book.Exceptions.ErrorHandling;

import com.teste.implementabiblioteca.Model.Author.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Model.Book.TypeExceptions.BookNotFound;
import com.teste.implementabiblioteca.Model.Book.TypeExceptions.ErrorSavingBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorHandlingBook {
    public static ResponseEntity<?> MapBook(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "BookNotFound" -> {
                return Convert((BookNotFound) e);
            }
            case "ListEmpty" -> {
                return Convert((ListEmpty) e);
            }
            case "ErrorSavingBook" -> {
                return Convert((ErrorSavingBook) e);
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
    public static ResponseEntity<?> Convert(ListEmpty e) {
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        String message = "A lista é vazia " ;
        return ResponseEntity.status(statusCode).body(message);
    }
    public static ResponseEntity<?> Convert(ErrorSavingBook e) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ("Não foi possivel inserir o Livro.");
        return ResponseEntity.status(statusCode).body(message);
    }
}
