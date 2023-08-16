package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Services.Author.Exceptions.TypeExceptions.ListEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorByLastName {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public List<AuthorEntity> GetAuthorByLastName(String lastName) throws ListEmpty{
        List<AuthorEntity> listAuthor = repositoryAuthor.GetAuthorByLastName(lastName);
        if (listAuthor.isEmpty()){
            throw new ListEmpty();
        }
        return listAuthor;
    }

}
