package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.exception.RentalNotFoundException;
import com.willianaraujo.toolsrental.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rentals")
public class RentalsController {

    private RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid RentalDTO rentalDTO) {
        return rentalService.create(rentalDTO);
    }

    @GetMapping("/{id}")
    public RentalDTO findById(@PathVariable Long id) throws RentalNotFoundException {
        return rentalService.findById(id);
    }
}
