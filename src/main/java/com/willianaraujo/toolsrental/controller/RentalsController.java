package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.Rental;
import com.willianaraujo.toolsrental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rentals")
public class RentalsController {

    private RentalRepository rentalRepository;

    @Autowired
    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Rental rental){
        Rental saveRental = rentalRepository.save(rental);
        return MessageResponseDTO.builder()
                .message("Aluguel " + saveRental.getId() + " realizado com sucesso.")
                .build();
    }
}
