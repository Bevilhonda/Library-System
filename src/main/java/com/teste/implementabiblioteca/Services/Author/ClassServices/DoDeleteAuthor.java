package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.AuthorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoDeleteAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public Integer Delete(Integer id) throws AuthorNotFound {

        AuthorEntity idAuthor = repositoryAuthor.GetAuthor(id);
        if (idAuthor == null) {
            throw new AuthorNotFound(id);
        }
        repositoryAuthor.deleteAuthor(id);
        return id;
    }
}