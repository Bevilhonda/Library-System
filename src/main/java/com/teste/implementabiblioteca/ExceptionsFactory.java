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
                return convert((ListEmptyException) e);
            }
            case "ArithmeticException" -> {
                return convert((ArithmeticException) e);
            }
            case "NullPointerException" -> {
                return convert((NullPointerException) e);
            }
            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o autor.");
            }
        }
    }

    public static ResponseEntity<?> maplist(Throwable e) {
        return convert((ListEmptyException) e);
    }

    public static ResponseEntity<?> convert(AutorNotFound e) {
        HttpStatus tipo_erro = HttpStatus.NOT_FOUND;
        String mensagem_de_erro = "O Autor com o id " + e.getId() + " não  foi encontrado.";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }

    public static ResponseEntity<?> convert(ArithmeticException e) {
        HttpStatus tipo_erro = HttpStatus.BAD_REQUEST;
        String mensagem_de_erro = "Erro de calculo.";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }

    public static ResponseEntity<?> convert(NullPointerException e) {
        HttpStatus tipo_erro = HttpStatus.BAD_REQUEST;
        String mensagem_de_erro = "Não foi possivel encontrar ou não existe.";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }

    public static ResponseEntity<?> convert(ListEmptyException e) {
        HttpStatus tipo_erro = HttpStatus.NOT_FOUND;
        String mensagem_de_erro = "Não existe o sobrenome " + e.getSobrenome() + " no cadastro ";
        return ResponseEntity.status(tipo_erro).body(mensagem_de_erro);
    }
}
