package com.teste.implementabiblioteca.FormatterResponses;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFormatterAuthor {
    public static ResponseEntity<?> FormatAuthorResponse(AuthorEntity author) {
        HttpStatus status = HttpStatus.OK;

        JSONObject jsonResponseAuthor = new JSONObject();
        jsonResponseAuthor.put("Id: ", author.getIdAuthor());
        // put serve para criar as chaves {} , cada put cria uma nova chave

        JSONObject nomeAuthorJson = new JSONObject();
        nomeAuthorJson.put("Primeiro", author.getName());
        nomeAuthorJson.put("Segundo", author.getLastname());

        jsonResponseAuthor.put("nome: ", nomeAuthorJson);

        jsonResponseAuthor.put("data nascimento: ", author.getDateBirth().getYear());

        return ResponseEntity.status(status).body(jsonResponseAuthor.toString());
    }
}