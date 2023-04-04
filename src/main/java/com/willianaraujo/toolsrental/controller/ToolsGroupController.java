package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.repository.ToolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/toolsgroup")
public class ToolsGroupController {


    private ToolGroupRepository toolGroupRepository;

    @Autowired
    public ToolsGroupController(ToolGroupRepository toolGroupRepository) {
        this.toolGroupRepository = toolGroupRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody ToolGroup toolGroup){
        ToolGroup saveToolGroup = toolGroupRepository.save(toolGroup);
        return MessageResponseDTO.builder()
                .message("Grupo de Ferramentas " + saveToolGroup.getId()  + " criado com sucesso.")
                .build();

    }
}
