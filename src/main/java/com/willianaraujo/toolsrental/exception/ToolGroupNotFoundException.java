package com.willianaraujo.toolsrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToolGroupNotFoundException extends Exception {
    public ToolGroupNotFoundException(Long id) {
        super(String.format("Grupo de ferramentas não encontrado", id));
    }
}
