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
        Assertions.assertEquals(expectedFoundTool.getToolGroupId().getId(), toolDTO.getToolGroupId().getId());
        Assertions.assertEquals(expectedFoundTool.getToolGroupId().getName(), toolDTO.getToolGroupId().getName());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getId(), toolDTO.getOwnerAddressId().getUserId().getId());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getName(), toolDTO.getOwnerAddressId().getUserId().getName());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getEmail(), toolDTO.getOwnerAddressId().getUserId().getEmail());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getUserId().getPhone(), toolDTO.getOwnerAddressId().getUserId().getPhone());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getStreet(), toolDTO.getOwnerAddressId().getStreet());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getNumber(), toolDTO.getOwnerAddressId().getNumber());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getComplement(), toolDTO.getOwnerAddressId().getComplement());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getNeighborhood(), toolDTO.getOwnerAddressId().getNeighborhood());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getCity(), toolDTO.getOwnerAddressId().getCity());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getState(), toolDTO.getOwnerAddressId().getState());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getCountry(), toolDTO.getOwnerAddressId().getCountry());
        Assertions.assertEquals(expectedFoundTool.getOwnerAddressId().getZipCode(), toolDTO.getOwnerAddressId().getZipCode());

    }
}
