package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.exception.ToolGroupNotFoundException;
import com.willianaraujo.toolsrental.exception.ToolNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToolGroupServiceTest {

    @InjectMocks
    private ToolGroupService toolGroupService;

    @Mock
    private ToolGroupRepository toolGroupRepository;


    @Test
    void testGetToolGroup() throws ToolGroupNotFoundException {
        ToolGroup expectedFoundToolGroup = ToolGroupUtils.createFakeToolGroup();

        Mockito.when(toolGroupRepository.findById(expectedFoundToolGroup.getId())).thenReturn(Optional.of(expectedFoundToolGroup));

        ToolGroupDTO toolGroupDTO = toolGroupService.findById(expectedFoundToolGroup.getId());

        assertEquals(expectedFoundToolGroup.getName(), toolGroupDTO.getName());

    }

    @Test
    void testGetToolGroupNotFound() {
        var invalidId = 10L;

        when(toolGroupRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(ToolGroup.class)));


        Assertions.assertThrows(ToolGroupNotFoundException.class, () -> toolGroupService.findById(invalidId));


    }
}
