package com.teste.implementabiblioteca.Services.Author;

import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.ErrorSavingAuthor;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class Services {
    @Autowired
    private RepositoryAuthor repository;

    public AuthorEntity GetAutorById(Integer id) throws AuthorNotFound {

        AuthorEntity author = repository.GetAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        return author;
    }

    public List<AuthorEntity> GetAllAuthor() {
        return repository.GetAllAuthors();
    }

    public List<AuthorEntity> GetAuthorByLastName(String lastName) throws ListEmpty {
        List<AuthorEntity> listAuthor = repository.GetAuthorByLastName(lastName);
        if (listAuthor.isEmpty()) {
            throw new ListEmpty();
        }
        return listAuthor;
    }

    public List<AuthorEntity> getAuthorByDateBirth(String startDate, String finalDate) throws DateBirthNotFound {

        LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
        List<AuthorEntity> authors = repository.selectAuthorByDate(dataInicial, dataFinal);

        if (authors.isEmpty()) {
            throw new DateBirthNotFound(startDate, finalDate);
        }
        return authors;
    }

    public AuthorEntity Insert(AuthorEntity author) throws ErrorSavingAuthor {

        Integer insertData = repository.Save(author.getName(),
                author.getLastname(), author.getDateBirth());
        if (insertData == null) {
            throw new ErrorSavingAuthor();
        }
        return author;
    }

    public AuthorEntity updateAuthor(Integer id, AuthorEntity newauthor) throws AuthorNotFound {

        AuthorEntity author = repository.GetAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        repository.updateAuthor(newauthor.getName(), newauthor.getLastname(),
                newauthor.getDateBirth(), id);
        return newauthor;
    }

    public void Delete(Integer id) throws AuthorNotFound {

        AuthorEntity idAuthor = repository.GetAuthor(id);
        if (idAuthor == null) {
            throw new AuthorNotFound(id);
        }
        repository.deleteAuthor(id);
    }
}
