package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.service.ToolGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tools-group")
public class ToolsGroupController {

    private ToolGroupService toolGroupService;

    @Autowired
    public ToolsGroupController(ToolGroupService toolGroupService) {
        this.toolGroupService = toolGroupService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid ToolGroupDTO toolGroupDTO){
        return toolGroupService.create(toolGroupDTO);

    }
}
