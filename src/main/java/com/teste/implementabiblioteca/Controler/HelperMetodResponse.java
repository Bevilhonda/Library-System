package com.teste.implementabiblioteca.Controler;

import com.teste.implementabiblioteca.Model.AutorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class HelperMetodResponse {

    public static ResponseEntity<?> RetornoDetalhesAutor(String mensagem, HttpStatus respostadostatus) {

        return ResponseEntity.status(respostadostatus).body(mensagem);
    }

    public static ResponseEntity<?> DetalhesTodosAutores(List<AutorEntity> autorlist, HttpStatus atualStatus) {

        List<String> detalhesautores = new ArrayList<>();

        for (AutorEntity autor : autorlist) {

            String detalhesAutor = autor.getId_autor() + " " + autor.getNome() + " " + autor.getSobrenome() + " "
                    + autor.getData_nascimento();
            detalhesautores.add(detalhesAutor);
        }
        return ResponseEntity.status(atualStatus).body(detalhesautores);
    }
}
