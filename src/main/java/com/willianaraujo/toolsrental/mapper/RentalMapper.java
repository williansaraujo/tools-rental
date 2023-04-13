package com.willianaraujo.toolsrental.mapper;

import com.willianaraujo.toolsrental.dto.RentalDTO;
import com.willianaraujo.toolsrental.entity.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalMapper {

    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    Rental toModel(RentalDTO rentalDTO);

    RentalDTO toDTO(Rental rental);

}
