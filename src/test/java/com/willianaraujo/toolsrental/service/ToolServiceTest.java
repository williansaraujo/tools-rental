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

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(expectedFoundTool.getName(), toolDTO.getName());
        assertEquals(expectedFoundTool.getDescription(), toolDTO.getDescription());
        assertEquals(expectedFoundTool.getRentalRatePerDay(), toolDTO.getRentalRatePerDay());
        assertEquals(expectedFoundTool.getPhotoFilePath(), toolDTO.getPhotoFilePath());
        assertEquals(expectedFoundTool.getToolGroupId().getId(), toolDTO.getToolGroupId().getId());
        assertEquals(expectedFoundTool.getToolGroupId().getName(), toolDTO.getToolGroupId().getName());
        assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getId(), toolDTO.getOwnerAddressId().getUserId().getId());
        assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getName(), toolDTO.getOwnerAddressId().getUserId().getName());
        assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getEmail(), toolDTO.getOwnerAddressId().getUserId().getEmail());
        assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getPhone(), toolDTO.getOwnerAddressId().getUserId().getPhone());
        assertEquals(expectedFoundTool.getOwnerAddressId().getStreet(), toolDTO.getOwnerAddressId().getStreet());
        assertEquals(expectedFoundTool.getOwnerAddressId().getNumber(), toolDTO.getOwnerAddressId().getNumber());
        assertEquals(expectedFoundTool.getOwnerAddressId().getComplement(), toolDTO.getOwnerAddressId().getComplement());
        assertEquals(expectedFoundTool.getOwnerAddressId().getNeighborhood(), toolDTO.getOwnerAddressId().getNeighborhood());
        assertEquals(expectedFoundTool.getOwnerAddressId().getCity(), toolDTO.getOwnerAddressId().getCity());
        assertEquals(expectedFoundTool.getOwnerAddressId().getState(), toolDTO.getOwnerAddressId().getState());
        assertEquals(expectedFoundTool.getOwnerAddressId().getCountry(), toolDTO.getOwnerAddressId().getCountry());
        assertEquals(expectedFoundTool.getOwnerAddressId().getZipCode(), toolDTO.getOwnerAddressId().getZipCode());

    }
}
