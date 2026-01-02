package com.teste.implementabiblioteca.Model.Author.Exceptions;
public class DateBirthNotFound extends AuthorExceptions {

    private final String startDate;
    private final String finalDate;
    private final String message;
    public DateBirthNotFound(String start , String finalDate){
        this.startDate = start;
        this.finalDate = finalDate;
        message = "Não foi encontrado autor nascido entre: "
                + getStartDate() + " á: " + getFinalDate();
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
