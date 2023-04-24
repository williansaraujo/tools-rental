package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import com.willianaraujo.toolsrental.repository.ToolRepository;
import com.willianaraujo.toolsrental.utils.ToolUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ToolServiceTest {
    @Mock
    private ToolRepository toolRepository;

    @InjectMocks
    private ToolService toolService;

    @Test
    void testGetTool() {
        Tool expectedFoundTool = ToolUtils.createFakeTool();

        Mockito.when(toolRepository.findById(expectedFoundTool.getId())).thenReturn(Optional.of(expectedFoundTool));

        ToolDTO toolDTO = toolService.findById(expectedFoundTool.getId());

        Assertions.assertEquals(expectedFoundTool.getName(), toolDTO.getName());
        Assertions.assertEquals(expectedFoundTool.getDescription(), toolDTO.getDescription());
        Assertions.assertEquals(expectedFoundTool.getRentalRatePerDay(), toolDTO.getRentalRatePerDay());
        Assertions.assertEquals(expectedFoundTool.getPhotoFilePath(), toolDTO.getPhotoFilePath());

    }
}
