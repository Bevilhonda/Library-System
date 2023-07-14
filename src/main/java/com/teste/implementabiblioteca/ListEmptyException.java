package com.teste.implementabiblioteca;

public class ListEmptyException extends ResponseTypeExceptions{

    private String sobrenome ;

    public ListEmptyException() {

    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
