package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import com.willianaraujo.toolsrental.mapper.ToolGroupMapper;
import com.willianaraujo.toolsrental.mapper.ToolMapper;
import com.willianaraujo.toolsrental.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ToolService {
    private ToolRepository toolRepository;

    private final ToolMapper toolMapper = ToolMapper.INSTANCE;

    @Autowired
    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @PostMapping
    public MessageResponseDTO create(ToolDTO toolDTO){

        Tool toolToSave = toolMapper.toModel(toolDTO);

        Tool saveTool = toolRepository.save(toolToSave);
        return MessageResponseDTO.builder()
                .message("Ferramenta " + saveTool.getId() + " adicionada com sucesso.")
                .build();
    }
}
