package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.entity.Rental;
import com.willianaraujo.toolsrental.mapper.RentalMapper;
import com.willianaraujo.toolsrental.repository.RentalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RentalService {
    private RentalRepository rentalRepository;

    private final RentalMapper rentalMapper = RentalMapper.INSTANCE;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @PostMapping
    public MessageResponseDTO create(RentalDTO rentalDTO){

        Rental rentalToSave = rentalMapper.toModel(rentalDTO);

        Rental saveRental = rentalRepository.save(rentalToSave);
        return MessageResponseDTO.builder()
                .message("Aluguel " + saveRental.getId() + " realizado com sucesso.")
                .build();
    }
}
