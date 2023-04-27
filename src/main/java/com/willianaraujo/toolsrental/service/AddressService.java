package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.dto.MessageResponseDTO;
import com.willianaraujo.toolsrental.entity.Address;
import com.willianaraujo.toolsrental.entity.User;
import com.willianaraujo.toolsrental.exception.AddressNotFoundException;
import com.willianaraujo.toolsrental.mapper.AddressMapper;
import com.willianaraujo.toolsrental.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public MessageResponseDTO create(AddressDTO addressDTO) {

        Address addressToSave = addressMapper.toModel(addressDTO);

        Address saveAddress = addressRepository.save(addressToSave);
        return MessageResponseDTO.builder()
                .message("Endereço " + saveAddress.getId() + " criado com sucesso")
                .build();
    }

    public AddressDTO findById(Long id) throws AddressNotFoundException {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));
        return addressMapper.toDTO(address);
    }
}
