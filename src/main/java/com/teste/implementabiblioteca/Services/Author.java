package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.ErrorSavingAuthor;
import com.teste.implementabiblioteca.Controller.Author.MonitorExceptions.LastNameNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.*;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapDateBirth;
import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAuthor;
import static com.teste.implementabiblioteca.Controller.Author.FormatterResponse.TypesResponseAuthor.*;

@Service
public class Author {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public AuthorEntity GetAutorById(Integer id) throws AuthorNotFound {

        AuthorEntity author = repositoryAuthor.GetAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        return author;
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public ResponseEntity<?> GetAllAuthors() {
        List<AuthorEntity> authors = repositoryAuthor.GetAllAuthors();
        return DetailsAuthors(authors);
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    public ResponseEntity<?> GetAllAuthor() {
        List<AuthorEntity> authors = repositoryAuthor.GetAllAuthors();
        return AllAuthors(authors);
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public ResponseEntity<?> GetAutorByLastName(String lastName) {
        try {
            List<AuthorEntity> authors = repositoryAuthor.GetAuthorByLastName(lastName);

            if (authors.isEmpty()) {
                throw new LastNameNotFound(lastName);
            } else {
                return DetailsAuthors(authors);
            }
        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
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
        } catch (ResponseTypeExceptions e) {
            return MapDateBirth(e);
        }
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


    public ResponseEntity<?> Insert(AuthorEntity author) {
        try {
            Integer insertData = repositoryAuthor.Save(author.getIdAuthor(), author.getName(),
                    author.getLastname(), author.getDateBirth());
            if (insertData == null) {
                throw new ErrorSavingAuthor();
            }
            return SaveSucessfull();

        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }

    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public ResponseEntity<?> UpdateAuthor(Integer id, AuthorEntity author) {
        try {
            AuthorEntity dataAuthor = repositoryAuthor.GetAuthor(id);
            if (dataAuthor == null) {
                throw new AuthorNotFound(id);
            }
            repositoryAuthor.updateAuthor(author.getName(), author.getLastname(),
                    author.getDateBirth(), id);

        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
        return UpdateSucessfull(id);
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    public ResponseEntity<?> Delete(Integer id) {
        try {
            AuthorEntity dataAuthor = repositoryAuthor.GetAuthor(id);
            if (dataAuthor == null) {
                throw new AuthorNotFound(id);
            }
            repositoryAuthor.deleteAuthor(id);
        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
        return DeleteSucessfull(id);
    }

}
