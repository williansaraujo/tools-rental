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


    }
}
