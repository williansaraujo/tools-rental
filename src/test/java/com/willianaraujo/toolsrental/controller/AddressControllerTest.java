package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.service.AddressService;
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
import com.willianaraujo.toolsrental.utils.AddressUtils;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.willianaraujo.toolsrental.utils.AddressUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

    String ADDRESS_API_URL_PATH = "/api/v1/addresses";

    private MockMvc mockMvc;

    private AddressDTO addressDTO;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressesController addressesController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(addressesController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }


    @Test
    void testAddressCreated() throws Exception {
        AddressDTO addressDTO = AddressUtils.createFakeAddressDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Endereço " + addressDTO.getId() + " criado com sucesso.")
                .build();

        when(addressService.create(addressDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(ADDRESS_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(addressDTO))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(expectedMessageResponse.getMessage())));
    }

}
