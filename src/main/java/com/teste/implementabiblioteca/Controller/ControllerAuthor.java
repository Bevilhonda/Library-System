package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author;
import com.teste.implementabiblioteca.repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.ReturnDetailsAuthor;

@RestController
public class ControllerAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

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

    @GetMapping("/Autor/DataNascimento")// rever sobre datas de nascimento no banco
    public ResponseEntity<?> GetAuthorByDateBirth(@RequestParam(value = "dataInicial") String startDate,
                                                  @RequestParam(value = "dataFinal") String finalDate) {
        return author.GetAuthorByDateBirth(startDate, finalDate);
    }

    @PostMapping("/Incluir_Autor")
    public ResponseEntity<?> InsertAuthor(@RequestBody AuthorEntity novo_autor) {
        return author.InsertAuthors(novo_autor);
    }

    @PutMapping("/UpdateAuthor")
    public ResponseEntity<?> UpdateAuthor(@RequestParam(value = "id_autor") Integer id, @RequestBody AuthorEntity novoautor) {
        return author.UpdateAuthor(id, novoautor);
    }

    @DeleteMapping("/DeleteAuthor")
    public ResponseEntity<?> DeleteAuthor(@RequestParam(value = "id_autor") Integer id) {
        return author.Delete(id);
    }
}
