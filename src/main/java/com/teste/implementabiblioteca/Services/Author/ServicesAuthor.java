package com.teste.implementabiblioteca.Services.Author;

import com.teste.implementabiblioteca.Model.Author.TypeExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.ErrorSavingAuthor;
import com.teste.implementabiblioteca.Model.Author.TypeExceptions.ListEmpty;
import com.teste.implementabiblioteca.Model.Author.AuthorEntity;
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

    public AuthorEntity getAutorById(Integer id) throws AuthorNotFound {

        AuthorEntity author = repository.getAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        return author;
    }

    public List<AuthorEntity> getAllAuthor() {
        return repository.getAllAuthors();
    }

    public List<AuthorEntity> getAuthorByLastName(String lastName) throws ListEmpty {
        List<AuthorEntity> listAuthor = repository.getAuthorByLastName(lastName);
        if (listAuthor.isEmpty()) {
            throw new ListEmpty();
        }
        return listAuthor;
    }

    public List<AuthorEntity> getauthorbydatebirth(String startDate, String finalDate) throws DateBirthNotFound {

        LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
        List<AuthorEntity> authors = repository.selectAuthorByDate(dataInicial, dataFinal);

        if (authors.isEmpty()) {
            throw new DateBirthNotFound(startDate, finalDate);
        }
        return authors;
    }

    public void insert(AuthorEntity author) throws ErrorSavingAuthor {

        Integer insertData = repository.save(author.getName(),
                author.getLastname(), author.getDateBirth());
        if (insertData == null) {
            throw new ErrorSavingAuthor();
        }
    }

    public void updateAuthor(Integer id, AuthorEntity newauthor) throws AuthorNotFound {

        AuthorEntity author = repository.getAuthor(id);

        repository.updateAuthor(newauthor.getName(), newauthor.getLastname(),
                newauthor.getDateBirth(), id);
    }

    public void delete(Integer id) throws AuthorNotFound {

        AuthorEntity idAuthor = repository.getAuthor(id);
        if (idAuthor == null) {
            throw new AuthorNotFound(id);
        }
        repository.deleteAuthor(id);
    }
}
