package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.LastNameNotFound;
import com.teste.implementabiblioteca.Model.AutorEntity;
import com.teste.implementabiblioteca.AutorNotFound;
import com.teste.implementabiblioteca.ResponseTypeExceptions;
import com.teste.implementabiblioteca.repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.teste.implementabiblioteca.Controler.HelperMetodResponse.DetalhesTodosAutores;
import static com.teste.implementabiblioteca.Controler.HelperMetodResponse.RetornoDetalhesAutor;
import static com.teste.implementabiblioteca.ExceptionsFactory.map;

@Service
public class Autor {
    @Autowired
    private RepositoryBiblioteca repository;


    public ResponseEntity<?> GetAutorById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AutorEntity autor = repository.GetAutor(id);

            if (autor == null) {
                throw new AutorNotFound(id);
            }
            return RetornoDetalhesAutor(autor.getId_autor() + " " +
                    autor.getNome() + " " +
                    autor.getSobrenome() + " " +
                    autor.getData_nascimento(), HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return map(e);
        }
    }

    public ResponseEntity<?> getAll_Autores() {
        List<AutorEntity> autores = repository.TodosAutores();
        return DetalhesTodosAutores(autores, HttpStatus.OK);
    }

    public ResponseEntity<?> GetAutorByLastName(String sobrenome) {
        try {
            List<AutorEntity> autores = repository.getAutorByLastname(sobrenome);

            if (autores.isEmpty()) {
                throw new LastNameNotFound(sobrenome);
            } else {
                return DetalhesTodosAutores(autores, HttpStatus.OK);
            }
        } catch (ResponseTypeExceptions e) {
            return map(e);
        }
    }
}
