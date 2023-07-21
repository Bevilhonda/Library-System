package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.Services.Library;
import com.teste.implementabiblioteca.repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLibrary {

    @Autowired
    private RepositoryLibrary repositorylibrary;

    @Autowired
    private Library library;

    @GetMapping("/Library/id")
    public ResponseEntity<?> GetLibraryById(@RequestParam (value = "id_biblioteca") Integer id){
        return library.GetLibraryById(id);
    }
}
