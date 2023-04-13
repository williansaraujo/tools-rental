package com.willianaraujo.toolsrental.mapper;

import com.willianaraujo.toolsrental.dto.ToolDTO;
import com.willianaraujo.toolsrental.entity.Tool;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToolMapper {

    ToolMapper INSTANCE = Mappers.getMapper(ToolMapper.class);

    Tool toModel(ToolDTO toolDTO);

    ToolDTO toDTO(Tool tool);

}
