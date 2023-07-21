package com.teste.implementabiblioteca.MonitorExceptions;

public class LastNameNotFound extends ResponseTypeExceptions {

    private String sobrenome ;

    public LastNameNotFound(String lastName) {
        this.sobrenome = lastName;

    }
    public String GetLastName() {
        return sobrenome;
    }
}
