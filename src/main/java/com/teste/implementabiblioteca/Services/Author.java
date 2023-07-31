package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.MonitorExceptions.DateBirthNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.LastNameNotFound;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.MonitorExceptions.AuthorNotFound;
import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapDateBirth;
import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.DetailsAllAuthors;
import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.ReturnDetailsAuthor;
import static com.teste.implementabiblioteca.MonitorExceptions.ExceptionsFactory.MapAuthor;

@Service
public class Author {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public ResponseEntity<?> GetAutorById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AuthorEntity author = repositoryAuthor.GetAuthor(id);

            if (author == null) {
                throw new AuthorNotFound(id);
            }
            return ReturnDetailsAuthor("Id: " + author.getIdAuthor() + "\n Nome: " +
                    author.getName() + "\n Sobrenome: " +
                    author.getLastname() + "\n Data Nascimento: " +
                    author.getDateBirth(), HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
    }

    public ResponseEntity<?> GetAllAuthors() {
        List<AuthorEntity> authors = repositoryAuthor.GetAllAuthors();
        return DetailsAllAuthors(authors, HttpStatus.OK);
    }

    public ResponseEntity<?> GetAutorByLastName(String lastName) {
        try {
            List<AuthorEntity> authors = repositoryAuthor.GetAuthorByLastName(lastName);

            if (authors.isEmpty()) {
                throw new LastNameNotFound(lastName);
            } else {
                return DetailsAllAuthors(authors, HttpStatus.OK);
            }
        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
    }

    public ResponseEntity<?> GetAuthorByDateBirth(String startDate, String finalDate) {
        try {
            LocalDate dataInicial = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
            LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ISO_DATE);
            List<AuthorEntity> autores = repositoryAuthor.selectAuthorByDate(dataInicial, dataFinal);

            if (autores.isEmpty()) {
                throw new DateBirthNotFound(startDate, finalDate);

            } else {
                return DetailsAllAuthors(autores, HttpStatus.OK);
            }
        } catch (ResponseTypeExceptions e) {
            return MapDateBirth(e);
        }
    }

    public ResponseEntity<?> InsertAuthors(AuthorEntity author) {
        repositoryAuthor.saveAuthor(author.getIdAuthor(),author.getName(),
                author.getLastname(),author.getDateBirth());

        return ReturnDetailsAuthor("Adicionado" , HttpStatus.OK);
    }
    public ResponseEntity<?> UpdateAuthor(Integer id , AuthorEntity author){
       try {
           AuthorEntity dataAuthor = repositoryAuthor.GetAuthor(id);
           if (dataAuthor == null){
               throw new AuthorNotFound(id);
           }
           repositoryAuthor.updateAuthor(author.getName(), author.getLastname(),
                   author.getDateBirth(), id);

       } catch (ResponseTypeExceptions e) {
           return MapAuthor(e);
       }
        return ReturnDetailsAuthor("Autor atualizado com sucesso", HttpStatus.OK);
    }

    public ResponseEntity<?> Delete(Integer id ){
        try {
            AuthorEntity dataAuthor = repositoryAuthor.GetAuthor(id);
            if (dataAuthor == null){
                throw new AuthorNotFound(id);
            }
            repositoryAuthor.deleteAuthor(id);
        } catch (ResponseTypeExceptions e) {
            return MapAuthor(e);
        }
        return ReturnDetailsAuthor("Autor do id " + id + " foi deletado do banco", HttpStatus.OK);
    }

}
