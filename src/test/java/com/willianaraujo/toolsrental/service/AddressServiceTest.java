package com.willianaraujo.toolsrental.service;

import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.entity.Address;
import com.willianaraujo.toolsrental.repository.AddressRepository;
import com.willianaraujo.toolsrental.utils.AddressUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    void testGetAddress() {
        Address expectedFoundAddress = AddressUtils.createFakeAddress();

        Mockito.when(addressRepository.findById(expectedFoundAddress.getId())).thenReturn(Optional.of(expectedFoundAddress));

        AddressDTO addressDTO = addressService.findById(expectedFoundAddress.getId());

        assertEquals(expectedFoundAddress.getStreet(), addressDTO.getStreet());
        assertEquals(expectedFoundAddress.getNumber(), addressDTO.getNumber());
        assertEquals(expectedFoundAddress.getComplement(), addressDTO.getComplement());
        assertEquals(expectedFoundAddress.getNeighborhood(), addressDTO.getNeighborhood());
        assertEquals(expectedFoundAddress.getState(), addressDTO.getState());
        assertEquals(expectedFoundAddress.getCity(), addressDTO.getCity());
        assertEquals(expectedFoundAddress.getCountry(), addressDTO.getCountry());
        assertEquals(expectedFoundAddress.getZipCode(), addressDTO.getZipCode());
        assertEquals(expectedFoundAddress.getUserId().getId(), addressDTO.getUserId().getId());
        assertEquals(expectedFoundAddress.getUserId().getName(), addressDTO.getUserId().getName());
        assertEquals(expectedFoundAddress.getUserId().getEmail(), addressDTO.getUserId().getEmail());
        assertEquals(expectedFoundAddress.getUserId().getPhone(), addressDTO.getUserId().getPhone());

    }
}
