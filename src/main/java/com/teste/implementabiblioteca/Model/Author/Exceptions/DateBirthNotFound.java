package com.teste.implementabiblioteca.Model.Author.Exceptions;
public class DateBirthNotFound extends AuthorExceptions {

    private final String startDate;
    private final String finalDate;
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
