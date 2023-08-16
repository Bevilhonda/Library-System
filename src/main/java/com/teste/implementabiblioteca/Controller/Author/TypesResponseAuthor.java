package com.teste.implementabiblioteca.Controller.Author;

import com.teste.implementabiblioteca.Controller.Author.FormatterResponse.Body;
import com.teste.implementabiblioteca.Controller.Author.FormatterResponse.Name;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TypesResponseAuthor {

    public static ResponseEntity<?> Ok(AuthorEntity author) {

        return ResponseEntity.status(HttpStatus.OK).body(Body.from(author));
    }


    public static ResponseEntity<?> saveSucessfull() {
        String message = "Autor adicionado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(message);
    }


    public static ResponseEntity<?> updateSucessfull(Integer id) {
        String message = "O autor com o id: " + id + " foi atualizado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(message);
    }


    public static ResponseEntity<?> deleteSucessfull(Integer id) {
        String message = "O autor com o id: " + id + " foi excluido.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(message);
    }


    public static ResponseEntity<?> SearchAuthorsDatePeriod(List<AuthorEntity> authorList) {

        List<Body> detailsAuthor = authorList.stream().map(author ->
                new Body(author.getIdAuthor(),
                new Name(author.getName(), author.getLastname()),
                author.getDateBirth())).toList();

        return ResponseEntity.status(HttpStatus.OK).body(detailsAuthor);
    }


    public static ResponseEntity<?> AllAuthors(List<AuthorEntity> authorlist) {
        List<Body> authorDetailsList = authorlist.stream().map(author ->
                new Body(author.getIdAuthor(),
                        new Name(author.getName(), author.getLastname()),
                        author.getDateBirth())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(authorDetailsList);
    }

}
