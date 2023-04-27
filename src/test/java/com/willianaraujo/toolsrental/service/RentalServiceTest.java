package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.entity.Rental;
import com.willianaraujo.toolsrental.exception.RentalNotFoundException;
import com.willianaraujo.toolsrental.exception.ToolNotFoundException;
import com.willianaraujo.toolsrental.repository.RentalRepository;
import com.willianaraujo.toolsrental.utils.RentalUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentalServiceTest {

    @Mock
    private RentalRepository rentalRepository;

    @InjectMocks
    private RentalService rentalService;

    @Test
    void testGetRental() throws RentalNotFoundException {
        Rental expectedFoundRental = RentalUtils.createFakeRental();

        Mockito.when(rentalRepository.findById(expectedFoundRental.getId())).thenReturn(Optional.of(expectedFoundRental));

        RentalDTO rentalDTO = rentalService.findById(expectedFoundRental.getId());

        assertEquals(expectedFoundRental.getId(), rentalDTO.getId());
        assertEquals(expectedFoundRental.getRentalStartDate(), rentalDTO.getRentalStartDate());
        assertEquals(expectedFoundRental.getRentalEndDate(), rentalDTO.getRentalEndDate());
        assertEquals(expectedFoundRental.getToolId().getId(), rentalDTO.getToolId().getId());
        assertEquals(expectedFoundRental.getToolId().getDescription(), rentalDTO.getToolId().getDescription());
        assertEquals(expectedFoundRental.getToolId().getRentalRatePerDay(), rentalDTO.getToolId().getRentalRatePerDay());
        assertEquals(expectedFoundRental.getToolId().getPhotoFilePath(), rentalDTO.getToolId().getPhotoFilePath());
        assertEquals(expectedFoundRental.getToolId().getName(), rentalDTO.getToolId().getName());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getId(), rentalDTO.getToolId().getOwnerAddressId().getId());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getStreet(), rentalDTO.getToolId().getOwnerAddressId().getStreet());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getNumber(), rentalDTO.getToolId().getOwnerAddressId().getNumber());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getComplement(), rentalDTO.getToolId().getOwnerAddressId().getComplement());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getNeighborhood(), rentalDTO.getToolId().getOwnerAddressId().getNeighborhood());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getState(), rentalDTO.getToolId().getOwnerAddressId().getState());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getCity(), rentalDTO.getToolId().getOwnerAddressId().getCity());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getCountry(), rentalDTO.getToolId().getOwnerAddressId().getCountry());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getZipCode(), rentalDTO.getToolId().getOwnerAddressId().getZipCode());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getId(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getId());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getName(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getName());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getEmail(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getEmail());
        assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getPhone(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getPhone());
        assertEquals(expectedFoundRental.getToolId().getToolGroupId().getId(), rentalDTO.getToolId().getToolGroupId().getId());
        assertEquals(expectedFoundRental.getToolId().getToolGroupId().getName(), rentalDTO.getToolId().getToolGroupId().getName());


    }


    @Test
    void testGetRentalNotFound() {
        var invalidId = 10L;

        when(rentalRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(Rental.class)));

        assertThrows(RentalNotFoundException.class, () -> rentalService.findById(invalidId));
    }
}
