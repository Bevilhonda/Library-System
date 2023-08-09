package com.teste.implementabiblioteca.Controller;

import com.teste.implementabiblioteca.DAO.LibraryDAO;
import com.teste.implementabiblioteca.Services.Library;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
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
    @Autowired
    private LibraryDAO libraryDAO;

    @GetMapping("/Library/id")
    public ResponseEntity<?> GetLibraryById(@RequestParam(value = "id_biblioteca") Integer id) {
        return library.GetLibraryById(id);
    }

    @GetMapping("/Name")
    public ResponseEntity<?> GetNameLibrary(@RequestParam(value = "nome") String nome) {
        return library.GetLibraryByName(nome);
    }

    @GetMapping("/Name/Address")
    public ResponseEntity<?> GetNameAndAddresLibrary(@RequestParam(value = "nome") String nome) {
        return libraryDAO.GetAllLibrary(nome);
    }
}
