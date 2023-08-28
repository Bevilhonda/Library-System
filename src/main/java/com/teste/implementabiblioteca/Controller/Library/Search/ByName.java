package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByName {
    @Autowired
    private ServicesLibrary service;
    @GetMapping("/Name")
    public ResponseEntity<?> GetNameLibrary(@RequestParam(value = "nome") String nome) {
        return service.GetLibraryByName(nome);
    }
}
