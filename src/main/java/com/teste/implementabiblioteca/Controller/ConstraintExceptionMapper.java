package com.teste.implementabiblioteca.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice // essa anotação serve para para capturar exceções de validação
public class ConstraintExceptionMapper extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException errorValidation, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> errorsResponse = new HashMap<>();
        List<String> errorsValue = errorValidation.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        errorsResponse.put("errors", errorsValue);

        return ResponseEntity.badRequest().body(errorsResponse);
    }

    /* ResponseEntityExceptionHandler,é uma classe que é fornecida pelo Spring Framework
     para lidar com exceções relacionadas a respostas HTTP.*/

    /* MethodArgumentNotValidException , este é o método lançado quando ocorre falha de
    validação */

    /* List<String> errors = ex.getBindingResult(),  Essa parte de código pega as
    mensagens de erro de validação da exceção errorValidation.
     Ele acessa o objeto BindingResult da exceção para obter as informações
      de erro relacionadas à validação.
     */

    /* existe uma interface chamada ERRORS, que é do SPRING,
     com metotos que pega cada tipo de erro, e o .getFieldErrors() é um metodo que pega a lista de erros
      gerados (FieldError) da exceção, que contém informações sobre os campos que
       falharam na validação. O método getDefaultMessage de FieldError retorna a mensagem de erro definida
       nas anotações de validação , ou seja as mensagens que eu gravei em cada atributo na classse
        DataAuthorEntity */

    /* depois de mapear cada erro eles são colocados em uma lista , e adicionada no HASHMAP
    com a chave de nome "errorsResponse" e o valor da chave chamado errorValue
     */
    /* depois no corpo da resposta ResponseEntity é passado o Hashmap que foi chamado de
    errorsResponse
     */
}
