package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataAllAuthors {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public List<AuthorEntity> GetAllAuthor() {
        return repositoryAuthor.GetAllAuthors();
    }
}
