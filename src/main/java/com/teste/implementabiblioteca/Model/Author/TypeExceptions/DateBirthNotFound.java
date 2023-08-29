package com.teste.implementabiblioteca.Model.Author.TypeExceptions;

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
