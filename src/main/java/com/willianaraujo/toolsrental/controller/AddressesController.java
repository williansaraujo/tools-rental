package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.Address;
import com.willianaraujo.toolsrental.entity.User;
import com.willianaraujo.toolsrental.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddressesController {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressesController(AddressRepository addressRepository) {this.addressRepository = addressRepository;}

    @PostMapping
    public MessageResponseDTO create(@RequestBody Address address){
        Address saveAddress = addressRepository.save(address);
        return MessageResponseDTO.builder()
                .message("Endereço "+ saveAddress.getId() + " criado com sucesso" )
                .build();
    }

}
