package com.teste.implementabiblioteca.Model.Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryEntityTest {
    @Test
    void LibraryEntityTest(){

        LibraryEntity library =
                new LibraryEntity(1,"Maringá",2000);

        assertEquals(1,library.getIdLibrary());
        assertEquals("Maringá",library.getName());
        assertEquals(2000,library.getFkAddress());

    }

}