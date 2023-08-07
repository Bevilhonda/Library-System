package com.teste.implementabiblioteca.FormatterResponses;

import com.teste.implementabiblioteca.Model.AddressEntity;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFormatterAddress {
    public static ResponseEntity<?> FormatterAddressResponse(AddressEntity address) {
        HttpStatus status = HttpStatus.OK;

        JSONObject jsonResponseAddress = new JSONObject();
        jsonResponseAddress.put("Id", address.getIdAddress());

        JSONObject addressJson = new JSONObject();
        addressJson.put("Numero", address.getNumber());
        addressJson.put("Bairro", address.getZone());
        addressJson.put("Estado", address.getState());
        addressJson.put("Cidade", address.getCity());
        addressJson.put("Rua", address.getStreet());

        jsonResponseAddress.put("Endereço", addressJson);

        return ResponseEntity.status(status).body(jsonResponseAddress.toString());
    }
}
