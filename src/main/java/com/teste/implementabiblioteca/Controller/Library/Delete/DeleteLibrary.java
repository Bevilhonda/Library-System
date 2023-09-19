package com.teste.implementabiblioteca.Controller.Library.Delete;

import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
public class DeleteLibrary {
    @Autowired
    private ServicesLibrary services;
    @DeleteMapping("/DeleteLibrary/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            services.delete(id);
            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
