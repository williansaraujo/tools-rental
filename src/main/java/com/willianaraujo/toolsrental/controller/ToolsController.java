package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import com.willianaraujo.toolsrental.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tools")
public class ToolsController {
    private ToolRepository toolRepository;

    @Autowired
    public ToolsController(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Tool tool){
        Tool saveTool = toolRepository.save(tool);
        return MessageResponseDTO.builder()
                .message("Ferramenta " + saveTool.getId() + " adicionada com sucesso.")
                .build();
    }
}
