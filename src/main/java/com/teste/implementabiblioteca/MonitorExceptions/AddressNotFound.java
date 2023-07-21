package com.teste.implementabiblioteca.MonitorExceptions;

public class AddressNotFound extends ResponseTypeExceptions{
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
