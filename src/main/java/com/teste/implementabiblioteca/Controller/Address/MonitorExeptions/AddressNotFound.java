package com.teste.implementabiblioteca.Controller.Address.MonitorExeptions;

import com.teste.implementabiblioteca.MonitorExceptions.ResponseTypeExceptions;

public class AddressNotFound extends ResponseTypeExceptions {
    private Integer id ;
    public AddressNotFound(Integer id ){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
