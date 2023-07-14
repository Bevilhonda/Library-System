package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.ListEmptyException;
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
import static com.teste.implementabiblioteca.ExceptionsFactory.maplist;

@Service
public class Autor {
    @Autowired
    private RepositoryBiblioteca repository;

    public ResponseEntity<?> GetAutorById(Integer id) {
        try {
            // int a = 5 / 0 ;
            AutorEntity autor = repository.GetAutor(id);

            if (autor == null) {
                AutorNotFound idnull = new AutorNotFound();
                idnull.setId(id);
                throw idnull;
            }
            return RetornoDetalhesAutor(autor.getId_autor() + " " +
                    autor.getNome() + " " +
                    autor.getSobrenome() + " " +
                    autor.getData_nascimento(), HttpStatus.OK);

        } catch (ResponseTypeExceptions e) {
            return map(e);
        }
    }

    public ResponseEntity<?> GetAutorById_2(Integer id) {
        try {
            //int a = 5 / 0;
            AutorEntity autor = repository.GetAutor(id);

            if (autor == null) {
                throw new AutorNotFound();
            }
            return RetornoDetalhesAutor(autor.getId_autor() + " " +
                    autor.getNome() + " " +
                    autor.getSobrenome() + " " +
                    autor.getData_nascimento(), HttpStatus.OK);

        } catch (Exception | AutorNotFound e) {
            return map(e);
        }
    }

    public ResponseEntity<?> getAll_Autores() {

        try {

            List<AutorEntity> autores = repository.TodosAutores();

            if (autores.isEmpty()) {
                throw new ListEmptyException();
            } else {
                return DetalhesTodosAutores(autores, HttpStatus.OK);
            }
        }  catch (ResponseTypeExceptions e) {
            return maplist(e);
        }
    }

    public ResponseEntity<?> GetAutorByLastName(String sobrenome) {
        try {
            List<AutorEntity> autores = repository.getAutorByLastname(sobrenome);

            if (autores.isEmpty()) {
                ListEmptyException listempty = new ListEmptyException();
                listempty.setSobrenome(sobrenome);
                throw listempty;
            } else {
                return DetalhesTodosAutores(autores, HttpStatus.OK);
            }
        } catch (ResponseTypeExceptions e) {
            return map(e);
        }
    }
}
