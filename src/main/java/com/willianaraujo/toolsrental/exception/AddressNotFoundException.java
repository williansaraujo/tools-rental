package com.willianaraujo.toolsrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(Long id) {
        super(String.format("Endereço não encontrado", id));
    }
}
