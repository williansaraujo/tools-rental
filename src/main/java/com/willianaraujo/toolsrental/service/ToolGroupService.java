package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.mapper.ToolGroupMapper;
import com.willianaraujo.toolsrental.repository.ToolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class ToolGroupService {
    private ToolGroupRepository toolGroupRepository;


    private final ToolGroupMapper toolGroupMapper = ToolGroupMapper.INSTANCE;

    @Autowired
    public ToolGroupService(ToolGroupRepository toolGroupRepository) {
        this.toolGroupRepository = toolGroupRepository;
    }

    @PostMapping
    public MessageResponseDTO create(ToolGroupDTO toolGroupDTO) {

        ToolGroup toolGroupToSave = toolGroupMapper.toModel(toolGroupDTO);

        ToolGroup saveToolGroup = toolGroupRepository.save(toolGroupToSave);
        return MessageResponseDTO.builder()
                .message("Grupo de Ferramentas " + saveToolGroup.getId() + " criado com sucesso.")
                .build();

    }


    public ToolGroupDTO findById(Long id) {
        Optional<ToolGroup> optionalToolGroup = toolGroupRepository.findById(id);
        return toolGroupMapper.toDTO(optionalToolGroup.get());
    }
}
