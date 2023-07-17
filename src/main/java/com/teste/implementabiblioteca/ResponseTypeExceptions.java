package com.teste.implementabiblioteca;

import org.springframework.http.HttpStatus;

public abstract class ResponseTypeExceptions extends Throwable {

    public String getMensagem() {
        throw new RuntimeException("Not implemented");
    }

    public HttpStatus getStatus() {
        return HttpStatus.OK;
    }
}
