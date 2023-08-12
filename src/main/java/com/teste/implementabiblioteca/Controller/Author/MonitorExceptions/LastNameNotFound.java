package com.teste.implementabiblioteca.Controller.Author.MonitorExceptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class LastNameNotFound extends ResponseTypeExceptions {

    private String sobrenome ;

    public LastNameNotFound(String lastName) {
        this.sobrenome = lastName;

    }
    public String GetLastName() {
        return sobrenome;
    }
}
