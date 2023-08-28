package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import java.time.LocalDate;

public class Name {

    private final String title;
    private final Integer edition;
    private final LocalDate releaseDate;

    public Name(String title, Integer edition, LocalDate releaseDate) {
        this.title = title;
        this.edition = edition;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Integer getEdition() {
        return edition;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
