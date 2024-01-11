package com.teste.implementabiblioteca.Services.Author;

import com.teste.implementabiblioteca.Model.Author.Exceptions.*;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
import com.teste.implementabiblioteca.Model.Library.Exceptions.LibraryNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServicesAuthor {
    @Autowired
    private RepositoryAuthor repository;

    public AuthorEntity getById(Integer id) throws AuthorNotFound {

        AuthorEntity author = repository.getAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        return author;
    }

    public List<AuthorEntity> getAllAuthors() throws RegisterNotFound {

        List<AuthorEntity> listAuthor = repository.getAllAuthors();

        if (listAuthor.isEmpty() ){
            throw new RegisterNotFound();
        }
        return listAuthor;
    }

    public List<AuthorEntity> getByLastName(String lastName) throws LastNameNotFound {
        List<AuthorEntity> listAuthor = repository.getByLastName(lastName);

        if (listAuthor.isEmpty()) {
            throw new LastNameNotFound(lastName);
        }
        return listAuthor;
    }

    public List<AuthorEntity> getByDateBirth(String startDate, String finalDate) throws DateBirthNotFound {

        LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
        List<AuthorEntity> authors = repository.getByDate(dataInicial, dataFinal);

        if (authors.isEmpty()) {
            throw new DateBirthNotFound(startDate, finalDate);
        }
        return authors;
    }

    public List<AuthorEntity> getAllAuthorsByNameLibrary(Integer id) throws LibraryNotFound {

        List<AuthorEntity> listAuthors = repository.getListAuthorsInTheLibrary(id);

        if (listAuthors.isEmpty()) {
            throw new LibraryNotFound(id);
        }

        return listAuthors;
    }

    public void insert(AuthorEntity author) {

        repository.save(author.getName(),author.getLastname(), author.getDateBirth());

    }

    public void updateAuthor(Integer id, AuthorEntity authorEntity) throws AuthorNotFound {

        AuthorEntity author = repository.getAuthor(id);

        if (author == null){
            throw new AuthorNotFound(id);
        }

        repository.updateAuthor(authorEntity.getName(), authorEntity.getLastname(),
                authorEntity.getDateBirth(), id);
    }

    public void delete(Integer id) throws AuthorNotFound {

        AuthorEntity idAuthor = repository.getAuthor(id);
        if (idAuthor == null) {
            throw new AuthorNotFound(id);
        }
        repository.deleteAuthor(id);
    }
}
