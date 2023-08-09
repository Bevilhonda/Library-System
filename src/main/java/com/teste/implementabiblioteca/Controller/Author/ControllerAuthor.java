package com.teste.implementabiblioteca.Controller.Author;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author;
import com.teste.implementabiblioteca.Services.DataAuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ControllerAuthor {
    @Autowired
    private Author author;

    @GetMapping("/Author/{id}")
    public ResponseEntity<?> GetAuthorById(@PathVariable Integer id) {

        return author.GetAutorById(id);
    }

    @GetMapping("/Authors")
    public ResponseEntity<?> GetAll_Authors() {
        return author.GetAllAuthors();
    }

    @GetMapping("/Author/LastName/{lastname}")
    public ResponseEntity<?> GetAutorByLastName(@PathVariable String lastname) {
        return author.GetAutorByLastName(lastname);
    }

    @GetMapping("/Autor/DateBirth/{startDate}/{finalDate}")
    public ResponseEntity<?> GetAuthorByDateBirth(@PathVariable String startDate,
                                                  @PathVariable String finalDate) {
        return author.GetAuthorByDateBirth(startDate, finalDate);
    }

    @PostMapping("/InsertAuthor")
    public ResponseEntity<?> Insert(@RequestBody DataAuthorEntity newAuthor) {

        return author.Insert(newAuthor.toModel());
    }

    @PutMapping("/UpdateAuthor/{id}")
    public ResponseEntity<?> UpdateAuthor(@PathVariable Integer id, @RequestBody AuthorEntity novoautor) {
        return author.UpdateAuthor(id, novoautor);
    }

    @DeleteMapping("/DeleteAuthor/{id}")
    public ResponseEntity<?> DeleteAuthor(@PathVariable Integer id) {
        return author.Delete(id);
    }
}
