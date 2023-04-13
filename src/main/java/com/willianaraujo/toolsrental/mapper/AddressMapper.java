package com.willianaraujo.toolsrental.mapper;

import com.willianaraujo.toolsrental.dto.AddressDTO;
import com.willianaraujo.toolsrental.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toModel(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);

}
