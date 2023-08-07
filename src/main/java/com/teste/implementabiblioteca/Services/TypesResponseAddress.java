package com.teste.implementabiblioteca.Services;

import com.teste.implementabiblioteca.Model.AddressEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TypesResponseAddress {

    public static ResponseEntity<?> ReturnDetailsAddress(String message, HttpStatus currentstatus) {

        return ResponseEntity.status(currentstatus).body(message);
    }

    public static ResponseEntity<?> SaveAddressSucessfull() {
        String mensagem = "Endereço adicionado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }
    public static ResponseEntity<?> UpdateAddressSucessfull(Integer id) {
        String mensagem = "O endereço com o id: " + id + " foi atualizado com sucesso.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }
    public static ResponseEntity<?> DeleteAddressSucessfull(Integer id) {
        String mensagem = "O endereço com o id: " + id + " foi excluido.";
        HttpStatus status = HttpStatus.OK;
        return ResponseEntity.status(status).body(mensagem);
    }

    public static ResponseEntity<?> DetailsAllAddress(List<AddressEntity> addresslist, HttpStatus currentstatus) {

        List<String> detailsaddress = new ArrayList<>();

        for (AddressEntity address : addresslist) {

            String detailaddress = "Id: " + address.getIdAddress() + "\n Street:  " +
                    address.getStreet() + "\n Number:  " +
                    address.getNumber() + "\n Zone: " + address.getZone() + "\n City: " +
                    address.getCity() + "\n State: " + address.getState();

            detailsaddress.add(detailaddress);
        }
        return ResponseEntity.status(currentstatus).body(detailsaddress);
    }

}
