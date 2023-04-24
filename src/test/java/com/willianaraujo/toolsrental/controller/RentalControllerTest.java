package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.service.RentalService;
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
import com.willianaraujo.toolsrental.utils.RentalUtils;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.willianaraujo.toolsrental.utils.RentalUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class RentalControllerTest {

    private MockMvc mockMvc;

    String RENTALS_API_URL_PATH = "/api/v1/rentals";

    private RentalDTO rentalDTO;

    @Mock
    private RentalService rentalService;

    @InjectMocks
    private RentalsController rentalsController;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(rentalsController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }


    @Test
    void testRentalCreated() throws Exception {
        RentalDTO rentalDTO = RentalUtils.createFakeRentalDTO();

        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Aluguel " + rentalDTO.getId() + " realizado com sucesso.")
                .build();

        when(rentalService.create(rentalDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post(RENTALS_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(rentalDTO))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", Is.is(expectedMessageResponse.getMessage())));
    }
}
