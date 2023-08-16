package com.teste.implementabiblioteca.Controller.Author.DTO.FormatterResponse;

public class Name {
    private final String primeiro;
    private final String segundo;

    public Name(String primeiro, String segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public String getPrimeiro() {
        return primeiro;
    }

    public String getSegundo() {
        return segundo;
    }
}
