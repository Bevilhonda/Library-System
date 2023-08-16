package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorByID {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public AuthorEntity GetAutorById(Integer id) throws AuthorNotFound {

        AuthorEntity author = repositoryAuthor.GetAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        return author;
    }
}
