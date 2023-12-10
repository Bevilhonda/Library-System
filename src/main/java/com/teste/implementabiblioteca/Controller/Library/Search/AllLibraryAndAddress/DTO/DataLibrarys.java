package com.teste.implementabiblioteca.Controller.Library.Search.AllLibraryAndAddress.DTO;

import com.teste.implementabiblioteca.Model.Address.AddressEntity;
import com.teste.implementabiblioteca.Model.Library.LibraryEntity;

public record DataLibrarys(Integer idLibrary, String name, Integer address,CompleteAddress completeAddress) {

    public static DataLibrarys from(LibraryEntity library){
        AddressEntity addressEntity = new AddressEntity();

        CompleteAddress completeAddress =  CompleteAddress.from(addressEntity.getStreet(),
                addressEntity.getNumber(), library.getFkAddress(),addressEntity.getBoroughs(),addressEntity.getCity(),
                addressEntity.getState());

        return new DataLibrarys(library.getIdLibrary(),library.getName(),library.getFkAddress(),
                completeAddress);
    }


}

