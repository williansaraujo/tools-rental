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

        Assertions.assertEquals(expectedFoundAddress.getStreet(), addressDTO.getStreet());
        Assertions.assertEquals(expectedFoundAddress.getNumber(), addressDTO.getNumber());
        Assertions.assertEquals(expectedFoundAddress.getComplement(), addressDTO.getComplement());
        Assertions.assertEquals(expectedFoundAddress.getNeighborhood(), addressDTO.getNeighborhood());
        Assertions.assertEquals(expectedFoundAddress.getState(), addressDTO.getState());
        Assertions.assertEquals(expectedFoundAddress.getCity(), addressDTO.getCity());
        Assertions.assertEquals(expectedFoundAddress.getCountry(), addressDTO.getCountry());
        Assertions.assertEquals(expectedFoundAddress.getZipCode(), addressDTO.getZipCode());

    }
}
