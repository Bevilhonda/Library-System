package com.teste.implementabiblioteca.Controller.Library.Search;

import com.teste.implementabiblioteca.Controller.Library.DAO.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AllDetailsByName {

    @Autowired
    private LibraryDAO libraryDAO;

    @GetMapping("/Name/Address")
    public ResponseEntity<?> GetNameAndAddresLibrary(@RequestParam(value = "nome") String nome) {
        return libraryDAO.GetAllLibrary(nome);
    }
}
