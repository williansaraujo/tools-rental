package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.service.ToolService;
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
import com.willianaraujo.toolsrental.utils.ToolUtils;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.willianaraujo.toolsrental.utils.ToolUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class ToolControllerTest {

    private MockMvc mockMvc;

    String TOOLS_API_URL_PATH = "/api/v1/tools";


    private ToolDTO toolDTO;

    @Mock
    private ToolService toolService;

    @InjectMocks
    private ToolsController toolsController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(toolsController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }


    @Test
    void testToolCreated() throws Exception {
        ToolDTO toolDTO = ToolUtils.createFakeToolDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Ferramenta " + toolDTO.getId() + " criada com sucesso.")
                .build();

        when(toolService.create(toolDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(TOOLS_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(toolDTO))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(expectedMessageResponse.getMessage())));
    }

}
