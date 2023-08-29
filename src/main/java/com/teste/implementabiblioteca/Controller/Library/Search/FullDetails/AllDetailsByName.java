package com.teste.implementabiblioteca.Controller.Library.Search.FullDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AllDetailsByName {

    @Autowired
    private LibraryDAO libraryDAO;

    @GetMapping("/Name/Address/{name}")
    public ResponseEntity<?> GetNameAndAddresLibrary(@PathVariable String name) {
        return libraryDAO.GetAllLibrary(name);
    }
}
