package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author;
import com.teste.implementabiblioteca.repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.DetailsAllAuthors;
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
        return author.GetAuthorByDateBirth(startDate,finalDate);
    }

    @PostMapping("/Incluir_Autor") // se data for errada por exemplo 25/05/1300 ?
    public ResponseEntity<?> IncludeAuthor(@RequestBody AuthorEntity novo_autor) {
        repositoryAuthor.Save(novo_autor.getIdAuthor(), novo_autor.getName(), novo_autor.getLastname(),
                novo_autor.getDateOfBirth());
        return ReturnDetailsAuthor("Autor adicionado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/Update_novo")
    public ResponseEntity<?> NewUpdateAuthor(@RequestParam(value = "id_autor") Integer id, @RequestBody AuthorEntity novo_autor) {
        List<AuthorEntity> todos_autores = repositoryAuthor.GetAllAuthors();
        boolean autorEncontrado = false;

        for (AuthorEntity index_autor : todos_autores) {
            if (index_autor.getIdAuthor().equals(id)) {
                repositoryAuthor.updateAuthor(novo_autor.getName(), novo_autor.getLastname(), novo_autor.getDateOfBirth(), id);
                autorEncontrado = true;
                break;
            }
        }
        if (autorEncontrado) {
            return ReturnDetailsAuthor("Alterado com sucesso ", HttpStatus.OK);
        } else {
            return ReturnDetailsAuthor("Não consta este autor.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Update")
    public ResponseEntity<?> UpdateAuthor(@RequestParam(value = "id_autor") Integer id, @RequestBody AuthorEntity novoautor) {
        AuthorEntity author = repositoryAuthor.GetAuthor(id);
        if (author == null) {
            return ReturnDetailsAuthor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        } else {
            repositoryAuthor.updateAuthor(novoautor.getName(), novoautor.getLastname(), novoautor.getDateOfBirth(), id);
            return ReturnDetailsAuthor("Autor atualizado com sucesso", HttpStatus.OK);
        }
    }

    @DeleteMapping("/Delete")
    public ResponseEntity<?> DeleteAuthor(@RequestParam(value = "id_autor") Integer id) {
        AuthorEntity author = repositoryAuthor.GetAuthor(id);
        if (author == null) {
            return ReturnDetailsAuthor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        }
        repositoryAuthor.deleteAuthor(id);
        return ReturnDetailsAuthor("Autor do id " + id + " foi deletado do banco", HttpStatus.OK);
    }
}
