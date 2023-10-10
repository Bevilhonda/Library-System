package com.teste.implementabiblioteca.Controller.Book.Search.AllBooks.DTO;

import java.time.LocalDate;

public record Name (String title, Integer edition, LocalDate releaseDate){
    public static Name createName(String title, Integer edition, LocalDate releaseDate){
        return new Name(title,edition,releaseDate);
    }

}
