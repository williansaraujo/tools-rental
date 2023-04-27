package com.willianaraujo.toolsrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToolNotFoundException extends Exception {
    public ToolNotFoundException(Long id) {
        super(String.format("Ferramenta não encontrada", id));
    }
}
