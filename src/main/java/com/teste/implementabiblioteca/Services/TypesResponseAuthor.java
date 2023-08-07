package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TypesResponseAuthor {

    public static ResponseEntity<?> Ok(AuthorEntity author) {
        HttpStatus status = HttpStatus.OK;
        String mensagem = ("Id: " + author.getIdAuthor() + "\n Nome: " +
                author.getName() + "\n Sobrenome: " +
                author.getLastname() + "\n Data Nascimento: " +
                author.getDateBirth());
        return ResponseEntity.status(status).body(mensagem);
    }

    public static ResponseEntity<?> SaveSucessfull() {
        String mensagem = "Autor adicionado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }

    public static ResponseEntity<?> UpdateSucessfull(Integer id) {
        String mensagem = "O autor com o id: " + id + " foi atualizado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }
    public static ResponseEntity<?> DeleteSucessfull(Integer id) {
        String mensagem = "O autor com o id: " + id + " foi excluido.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }

    public static ResponseEntity<?> DetailsAuthors(List<AuthorEntity> authorlist) {

        List<String> detailsauthor = new ArrayList<>();
        HttpStatus currentstatus = HttpStatus.OK;

        for (AuthorEntity author : authorlist) {

            String details = author.getIdAuthor() + " " + author.getName() + " " + author.getLastname() + " "
                    + author.getDateBirth();
            detailsauthor.add(details);
        }
        return ResponseEntity.status(currentstatus).body(detailsauthor);
    }
}
