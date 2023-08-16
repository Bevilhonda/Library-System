package com.teste.implementabiblioteca.Controller.Author.Endpoints.Insert;

import com.teste.implementabiblioteca.Controller.Author.DAO.DataAuthorEntity;
import com.teste.implementabiblioteca.Controller.Author.TypesResponseAuthor;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author.ClassServices.DoInsertAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.AuthorExceptions;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.ErrorSavingAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Services.Author.Exceptions.ErrorHandling.ErrorHandlingAuthor.MapAuthor;

@RestController
public class InsertAuhtor {
    @Autowired
    private DoInsertAuthor author;

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> Insert(@RequestBody DataAuthorEntity newAuthor) {
        try {
            AuthorEntity dataAuthor = author.Insert(newAuthor.toModel());
            if (dataAuthor == null) {
                throw new ErrorSavingAuthor();
            }
        } catch (AuthorExceptions e) {
            return MapAuthor(e);
        }
        return TypesResponseAuthor.SaveSucessfull();
    }
}
