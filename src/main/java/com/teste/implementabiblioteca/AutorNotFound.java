package com.teste.implementabiblioteca;

public class AutorNotFound extends ResponseTypeExceptions {
    private Integer id ;
    private String sobrenome;
    public AutorNotFound() {

    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
