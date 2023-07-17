package com.teste.implementabiblioteca;

public class LastNameNotFound extends ResponseTypeExceptions{

    private String sobrenome ;

    public LastNameNotFound(String sobrenome) {
        this.sobrenome = sobrenome;

    }
    public String getSobrenome() {
        return sobrenome;
    }
}
