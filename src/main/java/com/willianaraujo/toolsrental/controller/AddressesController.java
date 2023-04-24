package com.willianaraujo.toolsrental.controller;

import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressesController {

    private final AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid AddressDTO addressDTO) {
        return addressService.create(addressDTO);
    }

    @GetMapping("{id}")
    public AddressDTO findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

}
