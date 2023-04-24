package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.UserDTO;
import com.willianaraujo.toolsrental.entity.User;
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
import com.willianaraujo.toolsrental.utils.UserUtils;
import com.willianaraujo.toolsrental.service.UserService;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static com.willianaraujo.toolsrental.utils.UserUtils.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    private User user;

    @Mock
    private UserService userService;

    String USER_API_URL_PATH = "/api/v1/users";

    @InjectMocks
    private UsersController usersController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usersController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void testUserCreated() throws Exception {
        UserDTO userDTO = UserUtils.createFakeUserDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Usuário " + userDTO.getId() + " criado com sucesso.")
                .build();

        when(userService.create(userDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(USER_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(expectedMessageResponse.getMessage())));
    }
}
