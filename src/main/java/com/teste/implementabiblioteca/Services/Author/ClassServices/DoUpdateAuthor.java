package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;

import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DoUpdateAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public AuthorEntity updateAuthor(Integer id, AuthorEntity newauthor) throws AuthorNotFound {

        AuthorEntity author = repositoryAuthor.GetAuthor(id);

        if (author == null) {
            throw new AuthorNotFound(id);
        }
        repositoryAuthor.updateAuthor(newauthor.getName(),newauthor.getLastname(),
                newauthor.getDateBirth(),id);
        return newauthor;
    }
}
