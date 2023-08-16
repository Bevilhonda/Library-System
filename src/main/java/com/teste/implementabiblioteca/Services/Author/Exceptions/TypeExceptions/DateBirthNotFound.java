package com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions;

import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;

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
