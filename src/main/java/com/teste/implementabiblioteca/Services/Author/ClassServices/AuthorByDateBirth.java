package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.DateBirthNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.teste.implementabiblioteca.Controller.Author.TypesResponseAuthor.DetailsAuthors;
import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@Service
public class AuthorByDateBirth {
    @Autowired
    private RepositoryAuthor repositoryAuthor;
    public ResponseEntity<?> GetAuthorByDateBirth(String startDate, String finalDate) {
        try {
            LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
            LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
            List<AuthorEntity> authors = repositoryAuthor.selectAuthorByDate(dataInicial, dataFinal);

            if (authors.isEmpty()) {
                throw new DateBirthNotFound(startDate, finalDate);

            } else {
                return DetailsAuthors(authors);
            }
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
    }

}
