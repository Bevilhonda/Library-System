package com.teste.implementabiblioteca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionsFactory {
    public static ResponseEntity<?> map(Throwable e) {

        switch (e.getClass().getSimpleName()) {
            case "AutorNotFound" -> {
                return convert((AutorNotFound) e);
            }
            case "ListEmptyException" -> {
                return convert((LastNameNotFound) e);
            }
            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> convert(AutorNotFound e) {
        HttpStatus tipo_erro = HttpStatus.NOT_FOUND;
        String mensagem_de_erro = "O Autor com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }

    public static ResponseEntity<?> convert(LastNameNotFound e) {
        HttpStatus tipo_erro = HttpStatus.NOT_FOUND;
        String mensagem_de_erro = "Não existe o sobrenome " + e.getSobrenome() + " no cadastro ";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }
}
