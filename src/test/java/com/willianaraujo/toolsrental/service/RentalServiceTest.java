package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.entity.Rental;
import com.willianaraujo.toolsrental.repository.RentalRepository;
import com.willianaraujo.toolsrental.utils.RentalUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RentalServiceTest {

    @Mock
    private RentalRepository rentalRepository;

    @InjectMocks
    private RentalService rentalService;

    @Test
    void getTestRental() {
        Rental expectedFoundRental = RentalUtils.createFakeRental();

        Mockito.when(rentalRepository.findById(expectedFoundRental.getId())).thenReturn(Optional.of(expectedFoundRental));

        RentalDTO rentalDTO = rentalService.findById(expectedFoundRental.getId());

        Assertions.assertEquals(expectedFoundRental.getId(), rentalDTO.getId());
        Assertions.assertEquals(expectedFoundRental.getRentalStartDate(), rentalDTO.getRentalStartDate());
        Assertions.assertEquals(expectedFoundRental.getRentalEndDate(), rentalDTO.getRentalEndDate());
        Assertions.assertEquals(expectedFoundRental.getToolId().getId(), rentalDTO.getToolId().getId());
        Assertions.assertEquals(expectedFoundRental.getToolId().getDescription(), rentalDTO.getToolId().getDescription());
        Assertions.assertEquals(expectedFoundRental.getToolId().getRentalRatePerDay(), rentalDTO.getToolId().getRentalRatePerDay());
        Assertions.assertEquals(expectedFoundRental.getToolId().getPhotoFilePath(), rentalDTO.getToolId().getPhotoFilePath());
        Assertions.assertEquals(expectedFoundRental.getToolId().getName(), rentalDTO.getToolId().getName());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getId(), rentalDTO.getToolId().getOwnerAddressId().getId());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getStreet(), rentalDTO.getToolId().getOwnerAddressId().getStreet());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getNumber(), rentalDTO.getToolId().getOwnerAddressId().getNumber());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getComplement(), rentalDTO.getToolId().getOwnerAddressId().getComplement());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getNeighborhood(), rentalDTO.getToolId().getOwnerAddressId().getNeighborhood());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getState(), rentalDTO.getToolId().getOwnerAddressId().getState());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getCity(), rentalDTO.getToolId().getOwnerAddressId().getCity());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getCountry(), rentalDTO.getToolId().getOwnerAddressId().getCountry());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getZipCode(), rentalDTO.getToolId().getOwnerAddressId().getZipCode());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getId(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getId());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getName(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getName());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getEmail(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getEmail());
        Assertions.assertEquals(expectedFoundRental.getToolId().getOwnerAddressId().getUserId().getPhone(), rentalDTO.getToolId().getOwnerAddressId().getUserId().getPhone());
        Assertions.assertEquals(expectedFoundRental.getToolId().getToolGroupId().getId(), rentalDTO.getToolId().getToolGroupId().getId());
        Assertions.assertEquals(expectedFoundRental.getToolId().getToolGroupId().getName(), rentalDTO.getToolId().getToolGroupId().getName());


    }
}
