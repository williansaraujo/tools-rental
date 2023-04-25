package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.repository.ToolGroupRepository;
import com.willianaraujo.toolsrental.utils.ToolGroupUtils;
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
public class ToolGroupServiceTest {

    @InjectMocks
    private ToolGroupService toolGroupService;

    @Mock
    private ToolGroupRepository toolGroupRepository;


    @Test
    void testGetToolGroup() {
        ToolGroup expectedFoundToolGroup = ToolGroupUtils.createFakeToolGroup();

        Mockito.when(toolGroupRepository.findById(expectedFoundToolGroup.getId())).thenReturn(Optional.of(expectedFoundToolGroup));

        ToolGroupDTO toolGroupDTO = toolGroupService.findById(expectedFoundToolGroup.getId());

        assertEquals(expectedFoundToolGroup.getName(), toolGroupDTO.getName());

    }
}
