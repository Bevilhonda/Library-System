package com.teste.implementabiblioteca.Controller.Author.MonitorExceptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class DateBirthNotFound extends ResponseTypeExceptions {

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
