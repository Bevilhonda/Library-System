package com.teste.implementabiblioteca.Model.Book;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookEntityTest {
    @Test
    void BookEntityTest(){

        LocalDate dataPublication = LocalDate.parse("2013-10-10");
        LocalDate dataPublication1 = LocalDate.parse("2013-10-12");
        BookEntity book =
                new BookEntity(
                        "Junit",
                        dataPublication,
                        1,
                        1,
                        1,
                        1

                );
        assertEquals("Junit",book.getTitle());
        assertEquals(1,book.getFkAuthor());
        assertEquals(dataPublication,book.getData_publication());
        assertEquals(1,book.getEdition());
        assertEquals(1,book.getFkLibrary());
        assertEquals(1,book.getIdBook());


    }

}