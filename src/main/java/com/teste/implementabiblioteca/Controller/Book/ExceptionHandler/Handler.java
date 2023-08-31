package com.teste.implementabiblioteca.Controller.Book.ExceptionHandler;

import com.teste.implementabiblioteca.Model.Author.Exceptions.ListEmpty;
import com.teste.implementabiblioteca.Model.Book.Exceptions.BookNotFound;
import com.teste.implementabiblioteca.Model.Book.Exceptions.ErrorSavingBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Handler {
    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "BookNotFound" -> {
                return convert((BookNotFound) e);
            }
            case "ListEmpty" -> {
                return convert((ListEmpty) e);
            }
            case "ErrorSavingBook" -> {
                return convert((ErrorSavingBook) e);
            }

            default -> {
                return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                        "Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> convert(BookNotFound e) {
        return ResponseEntity.status(NOT_FOUND).body(
                "O Livro com o id " + e.getId() + " não  foi encontrado.");
    }

    public static ResponseEntity<?> convert(ListEmpty e) {

        return ResponseEntity.status(NOT_FOUND).body("A lista é vazia ");
    }

    public static ResponseEntity<?> convert(ErrorSavingBook e) {

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                "Não foi possivel inserir o Livro.");
    }
}