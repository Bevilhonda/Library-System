package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Services.Author;
import com.teste.implementabiblioteca.repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.DetailsAllAuthors;
import static com.teste.implementabiblioteca.Services.HelperResponseAuthor.ReturnDetailsAuthor;

@RestController
public class ControllerAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    @Autowired
    private Author author;

    @GetMapping("/Author/Id")
    public ResponseEntity<?> BuscaAutorByID(@RequestParam(value = "id_autor") Integer id) {

        return author.GetAutorById(id);
    }
    @GetMapping("/AllAuthors")
    public ResponseEntity<?> GetAll_Authors() {
        return author.GetAllAuthors();
    }

    @GetMapping("/AuthorLastName")
    public ResponseEntity<?> GetAutorByLastName(@RequestParam(value = "sobrenome") String sobrenome) {
        return author.GetAutorByLastName(sobrenome);
    }



    @GetMapping("/BuscaAutorDataNascimento")// rever sobre datas de nascimento no banco
    public ResponseEntity<?> getDataNascimentoAutor(@RequestParam(value = "dataInicial") Instant datainicial,
                                                    @RequestParam(value = "dataFinal") Instant datafinal) {
        List<AuthorEntity> autores = repositoryAuthor.selectAuthorByDate(datainicial, datafinal);

        if (autores.isEmpty()) {
            return ReturnDetailsAuthor("Não constam autores entre essas datas.", HttpStatus.NOT_FOUND);

        } else {
            return DetailsAllAuthors(autores, HttpStatus.OK);
        }
    }

    @PostMapping("/Incluir_Autor") // se data for errada por exemplo 25/05/1300 ?
    public ResponseEntity<?> insere_autor(@RequestBody AuthorEntity novo_autor) {
        repositoryAuthor.saveAuthor(novo_autor.getIdAuthor(), novo_autor.getName(), novo_autor.getLastname(),
                novo_autor.getDateOfBirth());
        return ReturnDetailsAuthor("Autor adicionado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/Update_novo")
    public ResponseEntity<?> new_update_autor(@RequestParam(value = "id_autor") Integer id, @RequestBody AuthorEntity novo_autor) {
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
    public ResponseEntity<?> update_autor(@RequestParam(value = "id_autor") Integer id, @RequestBody AuthorEntity novoautor) {
        AuthorEntity autor_atual = repositoryAuthor.GetAuthor(id);
        if (autor_atual == null) {
            return ReturnDetailsAuthor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        } else {
            repositoryAuthor.updateAuthor(novoautor.getName(), novoautor.getLastname(), novoautor.getDateOfBirth(), id);
            return ReturnDetailsAuthor("Autor atualizado com sucesso", HttpStatus.OK);
        }
    }

    @DeleteMapping("/Delete")
    public ResponseEntity<?> deleta_autor(@RequestParam(value = "id_autor") Integer id) {
        AuthorEntity autor = repositoryAuthor.GetAuthor(id);
        if (autor == null) {
            return ReturnDetailsAuthor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        }
        repositoryAuthor.deleteAuthor(id);
        return ReturnDetailsAuthor("Autor do id " + id + " foi deletado do banco", HttpStatus.OK);
    }
}