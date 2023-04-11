package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.repository.ToolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ToolGroupService {
    private ToolGroupRepository toolGroupRepository;

    @Autowired
    public ToolGroupService(ToolGroupRepository toolGroupRepository) {
        this.toolGroupRepository = toolGroupRepository;
    }

    @PostMapping
    public MessageResponseDTO create(ToolGroup toolGroup){
        ToolGroup saveToolGroup = toolGroupRepository.save(toolGroup);
        return MessageResponseDTO.builder()
                .message("Grupo de Ferramentas " + saveToolGroup.getId()  + " criado com sucesso.")
                .build();

    }


}
