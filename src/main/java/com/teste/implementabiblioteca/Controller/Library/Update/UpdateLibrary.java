package com.teste.implementabiblioteca.Controller.Library.Update;

import com.teste.implementabiblioteca.Controller.Library.Update.DTO.RequestData;
import com.teste.implementabiblioteca.Services.Library.ServicesLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.teste.implementabiblioteca.Controller.Library.ExceptionHandler.Handler.map;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UpdateLibrary {
    @Autowired
    private ServicesLibrary service;

    @PutMapping("/UpdateLibrary/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody @Valid RequestData dataLibrary) {
        try {
            service.update(id, dataLibrary.toModel());
            return ResponseEntity.status(OK).build();

        } catch (Throwable e) {
            return map(e);
        }
    }
}
