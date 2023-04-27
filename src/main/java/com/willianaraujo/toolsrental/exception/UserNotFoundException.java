package com.willianaraujo.toolsrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super(String.format("Usuário não encontrado", id));
    }
}
