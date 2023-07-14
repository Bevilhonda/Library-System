package com.teste.implementabiblioteca.Controler;

import com.teste.implementabiblioteca.Model.AutorEntity;
import com.teste.implementabiblioteca.Services.Autor;
import com.teste.implementabiblioteca.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import static com.teste.implementabiblioteca.Controler.HelperMetodResponse.DetalhesTodosAutores;
import static com.teste.implementabiblioteca.Controler.HelperMetodResponse.RetornoDetalhesAutor;

@RestController
public class Controler {
    @Autowired
    private RepositoryBiblioteca repository;

    @Autowired
    private Autor autores;

    @GetMapping("/GetAutor_ID")
    public ResponseEntity<?> BuscaAutorByID(@RequestParam(value = "id_autor") Integer id) {

        return autores.GetAutorById(id);
    }

    @GetMapping("/GetAllAutores")
    public ResponseEntity<?> GetAll_Autores() {
        return autores.getAll_Autores();
    }

    @GetMapping("/GetAutorLastName")
    public ResponseEntity<?> GetAutorByLastName(@RequestParam(value = "sobrenome") String sobrenome) {
        return autores.GetAutorByLastName(sobrenome);
    }

    @GetMapping("/Autor")
    public ResponseEntity<?> busca_Autor_por_Id(@RequestParam(value = "id_autor") Integer id) {
        AutorEntity autor = repository.GetAutor(id);

        if (autor == null) {
            return RetornoDetalhesAutor("Não contem autor com o id :" + id + " no banco.", HttpStatus.NOT_FOUND);
        }
        return RetornoDetalhesAutor(autor.getId_autor() + " " +
                autor.getNome() + " " +
                autor.getSobrenome() + " " +
                autor.getData_nascimento(), HttpStatus.OK);
    }

    @GetMapping("/Todos_Autores")
    public ResponseEntity<?> getAll_Autores() {

        List<AutorEntity> autores = repository.TodosAutores();

        if (autores.isEmpty()) {
            return RetornoDetalhesAutor("Lista vazia", HttpStatus.NOT_FOUND);
        } else {
            return DetalhesTodosAutores(autores, HttpStatus.OK);
        }
    }

    @GetMapping("Sobrenomes")
    public ResponseEntity<?> BuscaAutores_por_Sobrenome(@RequestParam(value = "sobrenome") String sobrenome) {

        List<AutorEntity> autores = repository.getAutorByLastname(sobrenome);
        if (autores.isEmpty()) {
            return RetornoDetalhesAutor("Não consta autor com este sobrenome.", HttpStatus.NOT_FOUND);
        } else {
            return DetalhesTodosAutores(autores, HttpStatus.OK);
        }
    }

    @GetMapping("/BuscaAutorDataNascimento")// rever sobre datas de nascimento no banco
    public ResponseEntity<?> getDataNascimentoAutor(@RequestParam(value = "dataInicial") Instant datainicial,
                                                    @RequestParam(value = "dataFinal") Instant datafinal) {
        List<AutorEntity> autores = repository.SelectAutorBy_DataPeriodo(datainicial, datafinal);

        if (autores.isEmpty()) {
            return RetornoDetalhesAutor("Não constam autores entre essas datas.", HttpStatus.NOT_FOUND);

        } else {
            return DetalhesTodosAutores(autores, HttpStatus.OK);
        }
    }

    @PostMapping("/Incluir_Autor") // se data for errada por exemplo 25/05/1300 ?
    public ResponseEntity<?> insere_autor(@RequestBody AutorEntity novo_autor) {
        repository.Inclui_Autor(novo_autor.getId_autor(), novo_autor.getNome(), novo_autor.getSobrenome(),
                novo_autor.getData_nascimento());
        return RetornoDetalhesAutor("Autor adicionado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/Update_novo")
    public ResponseEntity<?> new_update_autor(@RequestParam(value = "id_autor") Integer id, @RequestBody AutorEntity novo_autor) {
        List<AutorEntity> todos_autores = repository.TodosAutores();
        boolean autorEncontrado = false;

        for (AutorEntity index_autor : todos_autores) {
            if (index_autor.getId_autor().equals(id)) {
                repository.Update_Autor(novo_autor.getNome(), novo_autor.getSobrenome(), novo_autor.getData_nascimento(), id);
                autorEncontrado = true;
                break;
            }
        }
        if (autorEncontrado) {
            return RetornoDetalhesAutor("Alterado com sucesso ", HttpStatus.OK);
        } else {
            return RetornoDetalhesAutor("Não consta este autor.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/Update")
    public ResponseEntity<?> update_autor(@RequestParam(value = "id_autor") Integer id, @RequestBody AutorEntity novoautor) {
        AutorEntity autor_atual = repository.GetAutor(id);
        if (autor_atual == null) {
            return RetornoDetalhesAutor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        } else {
            repository.Update_Autor(novoautor.getNome(), novoautor.getSobrenome(), novoautor.getData_nascimento(), id);
            return RetornoDetalhesAutor("Autor atualizado com sucesso", HttpStatus.OK);
        }
    }

    @DeleteMapping("/Delete")
    public ResponseEntity<?> deleta_autor(@RequestParam(value = "id_autor") Integer id) {
        AutorEntity autor = repository.GetAutor(id);
        if (autor == null) {
            return RetornoDetalhesAutor("Não consta na lista este autor.", HttpStatus.NOT_FOUND);
        }
        repository.Delete_Autor(id);
        return RetornoDetalhesAutor("Autor do id " + id + " foi deletado do banco", HttpStatus.OK);
    }
}
