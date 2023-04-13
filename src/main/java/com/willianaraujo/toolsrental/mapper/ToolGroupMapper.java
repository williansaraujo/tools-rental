package com.willianaraujo.toolsrental.mapper;

import com.willianaraujo.toolsrental.dto.ToolGroupDTO;
import com.willianaraujo.toolsrental.entity.ToolGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToolGroupMapper {

    ToolGroupMapper INSTANCE = Mappers.getMapper(ToolGroupMapper.class);

    ToolGroup toModel(ToolGroupDTO toolGroupDTO);

    ToolGroupDTO toDTO(ToolGroup toolGroup);

}
