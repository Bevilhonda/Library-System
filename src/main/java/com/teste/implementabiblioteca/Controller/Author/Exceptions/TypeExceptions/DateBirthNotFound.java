package com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Controller.Author.Exceptions.ErrorHandling.AuthorExceptions;

public class DateBirthNotFound extends AuthorExceptions {

    private String startDate;
    private String finalDate;
    public DateBirthNotFound(String start , String finalDate){
        this.startDate = start;
        this.finalDate = finalDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }
}
