package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Services.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByIdLibrary {
    @Autowired
    private Library library;
    @GetMapping("/Library/id")
    public ResponseEntity<?> GetLibraryById(@RequestParam(value = "id_biblioteca") Integer id) {
        return library.GetLibraryById(id);
    }
}
