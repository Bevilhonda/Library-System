package com.teste.implementabiblioteca.Services.Author.ClassServices;

import com.teste.implementabiblioteca.Model.AuthorEntity;
import com.teste.implementabiblioteca.Repository.RepositoryAuthor;
import com.teste.implementabiblioteca.Controller.Author.Exceptions.TypeExceptions.ErrorSavingAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoInsertAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;
    public AuthorEntity Insert(AuthorEntity author) throws ErrorSavingAuthor {

            Integer insertData = repositoryAuthor.Save( author.getName(),
                    author.getLastname(), author.getDateBirth());
            if (insertData == null) {
                throw new ErrorSavingAuthor();
            }
            return author;
    }
}
