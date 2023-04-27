package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.exception.ToolGroupNotFoundException;
import com.willianaraujo.toolsrental.service.ToolGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tools-group")
public class ToolsGroupController {

    private ToolGroupService toolGroupService;

    @Autowired
    public ToolsGroupController(ToolGroupService toolGroupService) {
        this.toolGroupService = toolGroupService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid ToolGroupDTO toolGroupDTO) {
        return toolGroupService.create(toolGroupDTO);

    }

    @GetMapping("{id}")
    public ToolGroupDTO findById(@PathVariable Long id) throws ToolGroupNotFoundException {
        return toolGroupService.findById(id);
    }
}
