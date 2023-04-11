package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import com.willianaraujo.toolsrental.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ToolService {
    private ToolRepository toolRepository;

    @Autowired
    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @PostMapping
    public MessageResponseDTO create(Tool tool){
        Tool saveTool = toolRepository.save(tool);
        return MessageResponseDTO.builder()
                .message("Ferramenta " + saveTool.getId() + " adicionada com sucesso.")
                .build();
    }
}
