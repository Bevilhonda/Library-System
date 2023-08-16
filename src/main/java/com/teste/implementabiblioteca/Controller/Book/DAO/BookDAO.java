package com.teste.implementabiblioteca.Controller.Book.DAO;

import com.teste.implementabiblioteca.Controller.Author.DAO.DataAuthorEntity;
import com.teste.implementabiblioteca.Model.AddressEntity;
import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Model.BookEntity;
import com.teste.implementabiblioteca.Model.LibraryEntity;
import com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling.BookExceptions;
import com.teste.implementabiblioteca.Services.Book.Exceptions.TypeExceptions.BookNotFound;
import com.teste.implementabiblioteca.Repository.RepositoryAddress;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Repository.RepositoryBook;
import com.teste.implementabiblioteca.Repository.RepositoryLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.teste.implementabiblioteca.Services.Book.Exceptions.ErrorHandling.ErrorHandlingBook.MapBook;

@Service
public class BookDAO {

    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private RepositoryAuthor repositoryAuthor;
    @Autowired
    private RepositoryLibrary repositoryLibrary;
    @Autowired
    private RepositoryAddress repositoryAddress;

    public BookDAO() {

    }

    public ResponseEntity<?> GetBookByName(Integer idBook) {
        try {
            List<BookEntity> books = repositoryBook.GetBooksByID();
            if (books.isEmpty()) {
                throw new BookNotFound(idBook);
            }

            List<String> bookDetailsList = new ArrayList<>();

            for (BookEntity book : books) {

                if (Objects.equals(book.getIdBook(), idBook)) {

                    AuthorEntity author = repositoryAuthor.GetAuthor(book.getFkAuthor());
                    LibraryEntity library = repositoryLibrary.GetLibrary(book.getFkLibrary());
                    AddressEntity address = repositoryAddress.getAddress(library.getFkAddress());

                    String authorDetails = "Id: " + author.getIdAuthor() + ", Nome: " + author.getName() +
                            ", Sobrenome: " + author.getLastname() + ", Data Nascimento: " + author.getDateBirth();

                    String addressDetails = ", ID Endereço: " + library.getFkAddress()
                            + ", Rua: " + address.getStreet()
                            + ", Número: " + address.getNumber()
                            + ", Bairro: " + address.getZone()
                            + ", Cidade: " + address.getCity()
                            + ", Estado: " + address.getState();

                    String libraryDetails = ", ID Biblioteca: " + library.getIdLibrary()
                            + ", Nome: " + library.getName()
                            + ", Endereço: " + addressDetails;

                    bookDetailsList.add(authorDetails + libraryDetails);
                }
            }
            return new ResponseEntity<>(bookDetailsList, HttpStatus.OK);
        } catch (BookExceptions e) {
            return MapBook(e);
        }
    }


}
