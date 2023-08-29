package com.teste.implementabiblioteca.Controller.Library.Delete;

import com.teste.implementabiblioteca.Model.Library.TypeExceptions.LibraryExceptions;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.teste.implementabiblioteca.Controller.Library.Exceptions.ErrorHandling.ErrorHandlingLibrary.MapLibrary;
import static org.springframework.http.HttpStatus.*;

@RestController
public class DeleteLibrary {
    @Autowired
    private ServicesLibrary services;
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            services.delete(id);
            return ResponseEntity.status(OK).build();

        } catch (LibraryExceptions e) {
            return MapLibrary(e);
        }
    }
}
