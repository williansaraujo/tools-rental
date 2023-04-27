package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.exception.ToolNotFoundException;
import com.willianaraujo.toolsrental.service.ToolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tools")
public class ToolsController {
    private ToolService toolService;

    @Autowired
    public ToolsController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid ToolDTO toolDTO) {
        return toolService.create(toolDTO);
    }

    @GetMapping("/{id}")
    public ToolDTO findById(@PathVariable Long id) throws ToolNotFoundException {
        return toolService.findById(id);
    }
}
