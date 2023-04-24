package com.willianaraujo.toolsrental.controller;


import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolGroupDTO;

import com.willianaraujo.toolsrental.entity.ToolGroup;
import com.willianaraujo.toolsrental.service.ToolGroupService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import com.willianaraujo.toolsrental.utils.ToolGroupUtils;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.willianaraujo.toolsrental.utils.ToolGroupUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class ToolGroupControllerTest {

    String TOOL_GROUP_API_URL_PATH = "/api/v1/tools-group";

    private MockMvc mockMvc;

    private ToolGroup toolGroup;

    @Mock
    private ToolGroupService toolGroupService;

    @InjectMocks
    private ToolsGroupController toolsGroupController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(toolsGroupController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void testUserCreated() throws Exception {
        ToolGroupDTO toolGroupDTO = ToolGroupUtils.createFakeToolGroupDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Grupo de Ferramentas " + toolGroupDTO.getId() + " criado com sucesso.")
                .build();

        when(toolGroupService.create(toolGroupDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(TOOL_GROUP_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(toolGroupDTO))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(expectedMessageResponse.getMessage())));
    }

}
