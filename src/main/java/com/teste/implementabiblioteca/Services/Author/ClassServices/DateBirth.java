package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.DateBirthNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DateBirth {
    @Autowired
    private RepositoryAuthor repository;
    public List<AuthorEntity> from(String startDate, String finalDate) throws DateBirthNotFound {

            LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
            LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
            List<AuthorEntity> authors = repository.selectAuthorByDate(dataInicial, dataFinal);

            if (authors.isEmpty()) {
                throw new DateBirthNotFound(startDate, finalDate);
            }
            return authors;
    }

}
