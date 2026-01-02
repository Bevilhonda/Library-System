package com.teste.implementabiblioteca.Model.Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryEntityTest {
    @Test
    void LibraryEntityTest(){

        LibraryEntity library =
                new LibraryEntity(
                        1,
                        "Maringá",
                        "Gregorio",
                        12,
                        "Maringá",
                        "Centro",
                        "Paraná");

        assertEquals(1,library.getId_biblioteca());
        assertEquals("Maringá",library.getNome());
        assertEquals(12,library.getNumero());

    }

}