package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.service.ToolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tools")
public class ToolsController {
    private ToolService toolService;

    @Autowired
    public ToolsController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid ToolDTO toolDTO){
        return toolService.create(toolDTO);
    }
}
