package com.teste.implementabiblioteca;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class LastNameNotFound extends ResponseTypeExceptions {
    private final String sobrenome;
    private final HttpStatus status = NOT_FOUND;

    public LastNameNotFound(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String getMensagem() {
        String mensagem = "Não existe o sobrenome %s no cadastro";
        return mensagem.formatted(sobrenome);
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
