package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.MonitorExceptions.LastNameNotFound;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.MonitorExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.DetailsAllAuthors;
import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.ReturnDetailsAuthor;
import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAuthor;

@Service
public class Author {
    @Autowired
    private RepositoryAuthor repositoryauthor;


    public ResponseEntity<?> GetAutorById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AuthorEntity author = repositoryauthor.GetAuthor(id);

            if (author == null) {
                throw new AuthorNotFound(id);
            }
            return ReturnDetailsAuthor("Id: " +author.getIdAuthor() + "\n Nome: " +
                    author.getName() + "\n Sobrenome: " +
                    author.getLastname() + "\n Data Nascimento: " +
                    author.getDateOfBirth(), HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
    }

    public ResponseEntity<?> GetAllAuthors() {
        List<AuthorEntity> authors = repositoryauthor.GetAllAuthors();
        return DetailsAllAuthors(authors, HttpStatus.OK);
    }

    public ResponseEntity<?> GetAutorByLastName(String lastName) {
        try {
            List<AuthorEntity> authors = repositoryauthor.GetAuthorByLastName(lastName);

            if (authors.isEmpty()) {
                throw new LastNameNotFound(lastName);
            } else {
                return DetailsAllAuthors(authors, HttpStatus.OK);
            }
        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
    }
}
