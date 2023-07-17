package com.teste.implementabiblioteca;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class AutorNotFound extends ResponseTypeExceptions {
    private final Integer id;
    private final HttpStatus status = NOT_FOUND;

    public AutorNotFound(Integer id) {
        this.id = id;
    }

    @Override
    public String getMensagem() {
        String mensagem = "O Autor com o id %d não  foi encontrado.";
        return mensagem.formatted(id);
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
